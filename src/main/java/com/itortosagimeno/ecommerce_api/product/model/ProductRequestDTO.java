package com.itortosagimeno.ecommerce_api.product.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES;

public record ProductRequestDTO(
        @NotNull @NotBlank String name,
        @NotNull String description,
        @NotNull @PositiveOrZero Double price,
        @NotNull @JsonFormat(with = ACCEPT_CASE_INSENSITIVE_PROPERTIES) Category category,
        @NotNull String image,
        @NotNull @PositiveOrZero Integer stock
) {
}
