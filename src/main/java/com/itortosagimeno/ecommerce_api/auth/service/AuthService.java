package com.itortosagimeno.ecommerce_api.auth.service;

import com.itortosagimeno.ecommerce_api.auth.model.RegisterRequestDTO;
import com.itortosagimeno.ecommerce_api.auth.model.TokenResponse;
import com.itortosagimeno.ecommerce_api.exception.UserException;

public interface AuthService {
    TokenResponse register(RegisterRequestDTO registerRequestDTO) throws UserException;
}