package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.user.model.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
}