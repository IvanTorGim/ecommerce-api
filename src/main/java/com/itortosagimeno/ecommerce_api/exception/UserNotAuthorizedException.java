package com.itortosagimeno.ecommerce_api.exception;

public class UserNotAuthorizedException extends RuntimeException {
    public UserNotAuthorizedException() {
        super("User does not have permission");
    }
}
