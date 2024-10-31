package com.itortosagimeno.ecommerce_api.product.model.mapper;

import com.itortosagimeno.ecommerce_api.product.model.dto.OrderProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderProductResponse;
import com.itortosagimeno.ecommerce_api.product.model.entity.OrderEntity;
import com.itortosagimeno.ecommerce_api.product.model.entity.OrderProductEntity;
import com.itortosagimeno.ecommerce_api.product.model.entity.ProductEntity;

public class OrderProductMapper {

    public static OrderProductResponse toResponse(OrderProductEntity entity) {
        return new OrderProductResponse(
                entity.getId(),
                entity.getProduct().getId(),
                entity.getQuantity()
        );
    }

    public static OrderProductEntity toEntity(OrderProductRequest request, Integer orderId) {
        return new OrderProductEntity(
                new OrderEntity(orderId),
                new ProductEntity(request.productId()),
                request.quantity()
        );
    }
}
