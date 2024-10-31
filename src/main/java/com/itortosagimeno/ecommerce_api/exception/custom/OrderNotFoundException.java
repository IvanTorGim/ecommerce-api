package com.itortosagimeno.ecommerce_api.exception.custom;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Integer id) {
        super("Order with ID " + id + " not found");
    }
}