package com.itortosagimeno.ecommerce_api.exception;

public class UserExistsException extends RuntimeException {
    public UserExistsException() {
        super("The user already exists");
    }
}
