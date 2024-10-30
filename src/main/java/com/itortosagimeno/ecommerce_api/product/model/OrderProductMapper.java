package com.itortosagimeno.ecommerce_api.product.model;

public class OrderProductMapper {

    public static OrderProductResponse toResponse(OrderProductEntity entity) {
        return new OrderProductResponse(
                entity.getProduct().getId(),
                entity.getQuantity()
        );
    }
}
