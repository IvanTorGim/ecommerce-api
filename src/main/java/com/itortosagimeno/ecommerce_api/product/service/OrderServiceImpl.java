package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.model.mapper.OrderMapper;
import com.itortosagimeno.ecommerce_api.product.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public List<OrderResponse> getOrdersByAddressId(final Integer addressId) {
        return orderRepository.findAllByAddressId(addressId)
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public List<OrderResponse> getOrdersByUserId(Integer userId) {
        return orderRepository.findAllByUserId(userId)
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }
}
