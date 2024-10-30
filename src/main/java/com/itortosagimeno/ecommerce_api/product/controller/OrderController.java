package com.itortosagimeno.ecommerce_api.product.controller;

import com.itortosagimeno.ecommerce_api.product.model.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/private/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        final var orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
