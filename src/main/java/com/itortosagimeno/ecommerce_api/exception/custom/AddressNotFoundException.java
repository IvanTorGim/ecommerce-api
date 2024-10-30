package com.itortosagimeno.ecommerce_api.exception.custom;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(Integer id) {
        super("Address with ID " + id + " not found");
    }
}