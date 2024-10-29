package com.itortosagimeno.ecommerce_api.auth.service;

import com.itortosagimeno.ecommerce_api.auth.model.RegisterRequest;
import com.itortosagimeno.ecommerce_api.auth.model.TokenResponse;
import com.itortosagimeno.ecommerce_api.exception.UserExistsException;
import com.itortosagimeno.ecommerce_api.user.model.UserEntity;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public TokenResponse register(final RegisterRequest request) throws UserExistsException {
        var exists = userRepository.existsByEmail(request.email());
        if (exists) throw new UserExistsException();

        final var token = jwtService.generateToken(request);
        final var user = UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .token(token)
                .build();

        userRepository.save(user);
        return TokenResponse.builder()
                .accessToken(token)
                .build();
    }
}