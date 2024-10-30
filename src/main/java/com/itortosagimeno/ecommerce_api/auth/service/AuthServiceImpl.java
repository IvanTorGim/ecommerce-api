package com.itortosagimeno.ecommerce_api.auth.service;

import com.itortosagimeno.ecommerce_api.auth.model.RegisterRequest;
import com.itortosagimeno.ecommerce_api.auth.model.TokenResponse;
import com.itortosagimeno.ecommerce_api.exception.UserExistsException;
import com.itortosagimeno.ecommerce_api.user.model.UserEntity;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse register(final RegisterRequest request) throws UserExistsException {
        var exists = userRepository.existsByEmail(request.email());
        if (exists) throw new UserExistsException();

        final var token = jwtService.generateToken(request);
        final var entity = new UserEntity(
                request.email(),
                passwordEncoder.encode(request.password()),
                request.name(),
                token,
                request.role()
        );

        userRepository.save(entity);
        return new TokenResponse(token);
    }
}