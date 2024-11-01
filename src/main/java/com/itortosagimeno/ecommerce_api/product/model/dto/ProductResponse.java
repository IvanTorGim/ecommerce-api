package com.itortosagimeno.ecommerce_api.product.model.dto;


import com.itortosagimeno.ecommerce_api.product.model.common.Category;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response DTO for product details")
public record ProductResponse(
        @Schema(description = "Unique identifier of the product", example = "1")
        Integer id,
        @Schema(description = "Name of the product", example = "Wireless Mouse")
        String name,
        @Schema(description = "Description of the product", example = "A high-quality wireless mouse with ergonomic design")
        String description,
        @Schema(description = "Price of the product", example = "29.99")
        Double price,
        @Schema(description = "Category of the product", example = "ELECTRONICS")
        Category category,
        @Schema(description = "URL of the product image", example = "https://example.com/images/product.jpg")
        String image,
        @Schema(description = "Available stock of the product", example = "100")
        Integer stock
) {
}
