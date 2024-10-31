package com.itortosagimeno.ecommerce_api.product.model.dto;

public record OrderProductResponse(
        Integer id,
        Integer productId,
        Integer quantity
) {
}
