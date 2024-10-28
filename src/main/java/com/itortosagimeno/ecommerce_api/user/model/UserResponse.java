package com.itortosagimeno.ecommerce_api.user.model;

import lombok.Builder;

@Builder
public record UserResponse(
        Integer id,
        String email,
        String name,
        Role role
) {
}