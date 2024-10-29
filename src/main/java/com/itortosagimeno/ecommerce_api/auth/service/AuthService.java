package com.itortosagimeno.ecommerce_api.auth.service;

import com.itortosagimeno.ecommerce_api.auth.model.RegisterRequest;
import com.itortosagimeno.ecommerce_api.auth.model.TokenResponse;
import com.itortosagimeno.ecommerce_api.exception.UserExistsException;

public interface AuthService {
    TokenResponse register(RegisterRequest registerRequestDTO) throws UserExistsException;
}