package com.itortosagimeno.ecommerce_api.product.model.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderRequest(
        @NotNull Integer addressId,
        @NotNull List<OrderProductRequest> products
) {
}