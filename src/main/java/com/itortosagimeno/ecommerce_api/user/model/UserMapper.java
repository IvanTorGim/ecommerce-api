package com.itortosagimeno.ecommerce_api.user.model;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    public static UserResponse toResponse(UserEntity entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
    }

    public static UserEntity toEntity(UserRequest request, UserEntity entity, PasswordEncoder passwordEncoder) {
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setPassword(passwordEncoder.encode(request.password()));
        entity.setRole(request.role());
        return entity;
    }
}