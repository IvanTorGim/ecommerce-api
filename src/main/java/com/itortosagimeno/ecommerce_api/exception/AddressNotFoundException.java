package com.itortosagimeno.ecommerce_api.exception;

public class AddressNotFoundException extends Exception {
    public AddressNotFoundException(Integer id) {
        super("Address with ID " + id + " not found");
    }
}