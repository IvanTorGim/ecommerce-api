package com.itortosagimeno.ecommerce_api.exception;

public class UserExistsException extends Exception {
    public UserExistsException() {
        super("The user already exists");
    }
}
