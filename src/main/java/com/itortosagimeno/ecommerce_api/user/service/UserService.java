package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.user.model.dto.UserRequest;
import com.itortosagimeno.ecommerce_api.user.model.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUserById(Integer id);

    UserResponse updateUser(Integer id, UserRequest userRequest);

    void deleteUser(Integer id);
}