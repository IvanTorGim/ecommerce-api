package com.itortosagimeno.ecommerce_api.user.model;

public record UserRequest(
        String name,
        String email,
        String password,
        Role role
) {
}
