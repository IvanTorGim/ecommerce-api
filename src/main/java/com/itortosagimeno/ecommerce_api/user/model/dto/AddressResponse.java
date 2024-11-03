package com.itortosagimeno.ecommerce_api.user.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response DTO for address details")
public record AddressResponse(
        @Schema(description = "Unique identifier of the address", example = "1")
        Integer id,
        @Schema(description = "ID of the user associated with this address", example = "123")
        Integer userId,
        @Schema(description = "Street address", example = "123 Main St")
        String street,
        @Schema(description = "City of the address", example = "New York")
        String city,
        @Schema(description = "Country of the address", example = "USA")
        String country,
        @Schema(description = "Postal code or ZIP code of the address", example = "10001")
        String zipCode
) {
}