package com.itortosagimeno.ecommerce_api.auth.service;

import com.itortosagimeno.ecommerce_api.auth.model.RegisterRequest;
import com.itortosagimeno.ecommerce_api.auth.model.TokenResponse;

public interface AuthService {
    TokenResponse register(RegisterRequest registerRequestDTO);
}