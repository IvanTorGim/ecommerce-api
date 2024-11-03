package com.itortosagimeno.ecommerce_api.user.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request DTO for creating or updating an address")
public record AddressRequest(
        @Schema(description = "ID of the user associated with this address", example = "123")
        @NotNull Integer userId,
        @Schema(description = "Street address", example = "123 Main St")
        @NotBlank String street,
        @Schema(description = "City of the address", example = "New York")
        @NotBlank String city,
        @Schema(description = "Country of the address", example = "USA")
        @NotBlank String country,
        @Schema(description = "Postal code or ZIP code of the address", example = "10001")
        @NotBlank String zipCode
) {
}