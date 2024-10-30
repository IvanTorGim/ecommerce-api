package com.itortosagimeno.ecommerce_api.product.model.dto;

import com.itortosagimeno.ecommerce_api.product.model.common.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductRequest(
        @NotBlank String name,
        @NotNull String description,
        @NotNull @PositiveOrZero Double price,
        @NotNull Category category,
        @NotNull String image,
        @NotNull @PositiveOrZero Integer stock
) {
}
