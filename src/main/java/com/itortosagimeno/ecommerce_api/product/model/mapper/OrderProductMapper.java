package com.itortosagimeno.ecommerce_api.product.model.mapper;

import com.itortosagimeno.ecommerce_api.product.model.dto.OrderProductResponse;
import com.itortosagimeno.ecommerce_api.product.model.entity.OrderProductEntity;

public class OrderProductMapper {

    public static OrderProductResponse toResponse(OrderProductEntity entity) {
        return new OrderProductResponse(
                entity.getProduct().getId(),
                entity.getQuantity()
        );
    }
}
