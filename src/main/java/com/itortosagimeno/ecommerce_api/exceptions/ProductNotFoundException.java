package com.itortosagimeno.ecommerce_api.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Integer id) {
        super("Product with ID " + id + " not found");
    }
}
