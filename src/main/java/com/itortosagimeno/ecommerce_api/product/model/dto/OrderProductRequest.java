package com.itortosagimeno.ecommerce_api.product.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "Request DTO for specifying a product and its quantity in an order")
public record OrderProductRequest(
        @Schema(description = "Unique identifier of the product to be ordered", example = "101")
        @NotNull Integer productId,
        @Schema(description = "Quantity of the product to be ordered", example = "3", minimum = "1")
        @NotNull @Positive Integer quantity
) {
}