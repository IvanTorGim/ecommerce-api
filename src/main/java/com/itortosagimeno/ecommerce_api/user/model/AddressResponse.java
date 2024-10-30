package com.itortosagimeno.ecommerce_api.user.model;

public record AddressResponse(
        Integer id,
        Integer userId,
        String street,
        String city,
        String country,
        String zipCode
) {
}