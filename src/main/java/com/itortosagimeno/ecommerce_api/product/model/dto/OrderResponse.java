package com.itortosagimeno.ecommerce_api.product.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Response DTO for order details")
public record OrderResponse(
        @Schema(description = "Unique identifier of the order", example = "123")
        Integer Id,
        @Schema(description = "Date and time when the order was placed", example = "2023-10-31T14:30:00")
        LocalDateTime dateTime,
        @Schema(description = "ID of the address associated with the order", example = "456")
        Integer addressId,
        @Schema(description = "List of products included in the order")
        List<OrderProductResponse> products
) {
}
