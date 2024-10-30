package com.itortosagimeno.ecommerce_api.product.model.mapper;

import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.model.entity.OrderEntity;
import com.itortosagimeno.ecommerce_api.user.model.mapper.AddressMapper;

public class OrderMapper {

    public static OrderResponse toResponse(OrderEntity entity) {
        final var products = entity.getOrderProductList().stream()
                .map(OrderProductMapper::toResponse)
                .toList();
        return new OrderResponse(
                entity.getId(),
                entity.getDatetime(),
                AddressMapper.toResponse(entity.getAddress()),
                products
        );
    }
}