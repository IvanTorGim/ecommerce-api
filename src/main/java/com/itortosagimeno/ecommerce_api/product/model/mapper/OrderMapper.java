package com.itortosagimeno.ecommerce_api.product.model.mapper;

import com.itortosagimeno.ecommerce_api.product.model.dto.OrderRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.model.entity.OrderEntity;
import com.itortosagimeno.ecommerce_api.user.model.entity.AddressEntity;

import java.time.LocalDateTime;

public class OrderMapper {

    public static OrderResponse toResponse(OrderEntity entity) {
        final var products = entity.getOrderProductList().stream()
                .map(OrderProductMapper::toResponse)
                .toList();
        return new OrderResponse(
                entity.getId(),
                entity.getDatetime(),
                entity.getAddress().getId(),
                products
        );
    }

    public static OrderEntity toEntity(OrderRequest request) {
        return new OrderEntity(
                new AddressEntity(request.addressId()),
                LocalDateTime.now()
        );
    }
}
