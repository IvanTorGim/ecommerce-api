package com.itortosagimeno.ecommerce_api.auth.controller;

import com.itortosagimeno.ecommerce_api.auth.model.RegisterRequest;
import com.itortosagimeno.ecommerce_api.auth.model.TokenResponse;
import com.itortosagimeno.ecommerce_api.auth.service.AuthService;
import com.itortosagimeno.ecommerce_api.exception.UserExistsException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(
            @Valid @RequestBody final RegisterRequest registerRequest
    ) throws UserExistsException {
        final var token = authenticationService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(token);
    }
}
