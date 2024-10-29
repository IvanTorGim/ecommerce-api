package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.UserRequest;
import com.itortosagimeno.ecommerce_api.user.model.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUserById(Integer id) throws UserNotFoundException;

    UserResponse updateUser(Integer id, UserRequest userRequest) throws UserNotFoundException;

    void deleteUser(Integer id) throws UserNotFoundException;
}