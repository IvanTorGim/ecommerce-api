package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.product.model.dto.OrderRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAllOrders();

    List<OrderResponse> getOrdersByAddressId(Integer addressId);

    List<OrderResponse> getOrdersByUserId(Integer userId);

    OrderResponse getOrderById(Integer id);

    OrderResponse insertOrder(OrderRequest orderRequest);

    void deleteOrder(Integer id);
}
