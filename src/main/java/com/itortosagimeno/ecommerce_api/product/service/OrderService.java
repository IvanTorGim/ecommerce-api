package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.product.model.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAllOrders();
}
