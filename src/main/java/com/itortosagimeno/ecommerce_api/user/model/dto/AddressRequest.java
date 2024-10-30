package com.itortosagimeno.ecommerce_api.user.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressRequest(
        @NotNull Integer userId,
        @NotBlank String street,
        @NotBlank String city,
        @NotBlank String country,
        @NotBlank String zipCode
) {
}