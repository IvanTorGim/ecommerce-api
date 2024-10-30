package com.itortosagimeno.ecommerce_api.exception.custom;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer id) {
        super("Product with ID " + id + " not found");
    }
}
