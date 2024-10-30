package com.itortosagimeno.ecommerce_api.user.model.dto;

import com.itortosagimeno.ecommerce_api.user.model.common.Role;

public record UserResponse(
        Integer id,
        String email,
        String name,
        Role role
) {
}