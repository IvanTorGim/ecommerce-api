package com.itortosagimeno.ecommerce_api.user.model.dto;

import com.itortosagimeno.ecommerce_api.user.model.common.Role;

public record UserRequest(
        String name,
        String email,
        String password,
        Role role
) {
}
