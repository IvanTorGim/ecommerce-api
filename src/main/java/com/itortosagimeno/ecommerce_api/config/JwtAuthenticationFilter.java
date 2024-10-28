package com.itortosagimeno.ecommerce_api.config;

import com.itortosagimeno.ecommerce_api.auth.service.JwtService;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
    ) throws ServletException, IOException {

        final var authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            doFilter(request, response, filterChain);
            return;
        }

        final var token = authHeader.substring(7);
        final var userEmail = jwtService.extractUsername(token);
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (userEmail == null || authentication != null) {
            doFilter(request, response, filterChain);
            return;
        }

        final var userDetails = userDetailsService.loadUserByUsername(userEmail);
        final var optionalUser = userRepository.findByEmail(userEmail);

        if (userDetails == null || optionalUser.isEmpty()) {
            doFilter(request, response, filterChain);
            return;
        }

        final var matchUserTokenAndHeaderToken = optionalUser.get().getToken().equals(token);

        if (matchUserTokenAndHeaderToken) {
            final var authToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        doFilter(request, response, filterChain);
    }
}