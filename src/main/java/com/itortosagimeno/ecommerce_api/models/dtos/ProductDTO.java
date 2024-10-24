package com.itortosagimeno.ecommerce_api.models.dtos;

import com.itortosagimeno.ecommerce_api.models.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductDTO(
        @Null Integer id,
        @NotNull @NotBlank String name,
        @NotNull String description,
        @NotNull @PositiveOrZero Double price,
        @NotNull Category category,
        @NotNull String image,
        @NotNull @PositiveOrZero Integer stock
) {
}
