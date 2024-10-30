package com.itortosagimeno.ecommerce_api.user.model;

public record UserResponse(
        Integer id,
        String email,
        String name,
        Role role
) {
}