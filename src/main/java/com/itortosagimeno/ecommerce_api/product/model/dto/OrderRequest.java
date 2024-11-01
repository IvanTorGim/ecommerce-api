package com.itortosagimeno.ecommerce_api.product.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "Request DTO for creating a new order")
public record OrderRequest(
        @Schema(description = "ID of the address where the order will be delivered", example = "456")
        @NotNull Integer addressId,
        @Schema(description = "List of products to be included in the order")
        @NotNull List<OrderProductRequest> products
) {
}