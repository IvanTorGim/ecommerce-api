package com.itortosagimeno.ecommerce_api.user.model.dto;

public record AddressResponse(
        Integer id,
        Integer userId,
        String street,
        String city,
        String country,
        String zipCode
) {
}