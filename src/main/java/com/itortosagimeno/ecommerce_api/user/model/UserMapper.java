package com.itortosagimeno.ecommerce_api.user.model;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    public static UserResponse toResponse(UserEntity entity) {
        return new UserResponse(
                entity.getId(),
                entity.getEmail(),
                entity.getName(),
                entity.getRole()
        );
    }

    public static UserEntity toEntity(UserRequest request, UserEntity entity, PasswordEncoder passwordEncoder) {
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setPassword(passwordEncoder.encode(request.password()));
        entity.setRole(request.role());
        return entity;
    }
}