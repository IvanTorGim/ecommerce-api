package com.itortosagimeno.ecommerce_api.product.model.dto;

import com.itortosagimeno.ecommerce_api.product.model.common.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "Request DTO for creating or updating a product")
public record ProductRequest(
        @Schema(description = "Name of the product", example = "Wireless Mouse")
        @NotBlank String name,
        @Schema(description = "Description of the product", example = "A high-quality wireless mouse with ergonomic design")
        @NotNull String description,
        @Schema(description = "Price of the product, must be zero or positive", example = "29.99", minimum = "0")
        @NotNull @PositiveOrZero Double price,
        @Schema(description = "Category of the product", example = "ELECTRONICS")
        @NotNull Category category,
        @Schema(description = "URL of the product image", example = "https://example.com/images/product.jpg")
        @NotNull String image,
        @Schema(description = "Available stock of the product, must be zero or positive", example = "100", minimum = "0")
        @NotNull @PositiveOrZero Integer stock
) {
}
