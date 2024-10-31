package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.custom.OrderNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.model.mapper.OrderMapper;
import com.itortosagimeno.ecommerce_api.product.model.mapper.OrderProductMapper;
import com.itortosagimeno.ecommerce_api.product.repository.OrderProductRepository;
import com.itortosagimeno.ecommerce_api.product.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
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
    public List<OrderResponse> getOrdersByUserId(final Integer userId) {
        return orderRepository.findAllByUserId(userId)
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public OrderResponse getOrderById(final Integer id) {
        return orderRepository.findById(id)
                .map(OrderMapper::toResponse)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Transactional
    @Override
    public OrderResponse insertOrder(OrderRequest orderRequest) {
        final var orderEntity = OrderMapper.toEntity(orderRequest);
        final var orderSaved = orderRepository.save(orderEntity);
        final var orderProductEntityList = orderRequest.products()
                .stream()
                .map(orderProduct -> OrderProductMapper.toEntity(orderProduct, orderSaved.getId()))
                .toList();
        final var orderProductListSaved = orderProductRepository.saveAll(orderProductEntityList);
        orderSaved.setOrderProductList(orderProductListSaved);
        return OrderMapper.toResponse(orderEntity);
    }

    @Override
    public void deleteOrder(Integer id) {
        final var exists = orderRepository.existsById(id);
        if (!exists) throw new OrderNotFoundException(id);
        orderRepository.deleteById(id);
    }
}
