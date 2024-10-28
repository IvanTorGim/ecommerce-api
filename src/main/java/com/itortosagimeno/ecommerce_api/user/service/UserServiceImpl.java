package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.user.model.UserMapper;
import com.itortosagimeno.ecommerce_api.user.model.UserResponse;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
