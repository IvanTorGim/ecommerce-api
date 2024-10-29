package com.itortosagimeno.ecommerce_api.user.model;

import lombok.Builder;

@Builder
public record AddressResponse(
        Integer id,
        Integer userId,
        String street,
        String city,
        String country,
        String zipCode
) {
}