package com.itortosagimeno.ecommerce_api.product.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response DTO representing a product within an order")
public record OrderProductResponse(
        @Schema(description = "Unique identifier of the order product entry", example = "1")
        Integer id,
        @Schema(description = "Unique identifier of the product", example = "101")
        Integer productId,
        @Schema(description = "Quantity of the product in the order", example = "3")
        Integer quantity
) {
}
