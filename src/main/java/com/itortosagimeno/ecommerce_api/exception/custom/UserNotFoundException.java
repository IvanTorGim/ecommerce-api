package com.itortosagimeno.ecommerce_api.exception.custom;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("User with ID " + id + " not found");
    }
}
