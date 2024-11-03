package com.itortosagimeno.ecommerce_api.auth.controller;

import com.itortosagimeno.ecommerce_api.auth.model.RegisterRequest;
import com.itortosagimeno.ecommerce_api.auth.model.TokenResponse;
import com.itortosagimeno.ecommerce_api.auth.service.AuthService;
import com.itortosagimeno.ecommerce_api.exception.model.ApiException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication", description = "Endpoints for a user authentication and registration operations")
@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authenticationService;

    public AuthController(AuthService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Operation(summary = "Register a new user", description = "Creates a new user and returns an access token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully registered, token returned",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@Valid @RequestBody final RegisterRequest registerRequest) {
        final var token = authenticationService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(token);
    }
}
