package com.itortosagimeno.ecommerce_api.auth.controller;

import com.itortosagimeno.ecommerce_api.auth.model.RegisterRequest;
import com.itortosagimeno.ecommerce_api.auth.model.TokenResponse;
import com.itortosagimeno.ecommerce_api.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authenticationService;

    public AuthController(AuthService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@Valid @RequestBody final RegisterRequest registerRequest) {
        final var token = authenticationService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(token);
    }
}
