package com.itortosagimeno.ecommerce_api.product.controller;

import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/public/orders/addresses/{id}")
    public ResponseEntity<List<OrderResponse>> getOrdersByAddressId(@PathVariable("id") final Integer addressId) {
        final var orders = orderService.getOrdersByAddressId(addressId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/public/orders/users/{id}")
    public ResponseEntity<List<OrderResponse>> getOrdersByUserId(@PathVariable("id") final Integer userId) {
        final var orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }
}
