package com.itortosagimeno.ecommerce_api.product.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderProductRequest(
        @NotNull Integer productId,
        @Positive Integer quantity
) {
}