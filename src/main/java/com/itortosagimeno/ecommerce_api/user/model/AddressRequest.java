package com.itortosagimeno.ecommerce_api.user.model;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        Integer userId,
        @NotBlank String street,
        @NotBlank String city,
        @NotBlank String country,
        @NotBlank String zipCode
) {
}