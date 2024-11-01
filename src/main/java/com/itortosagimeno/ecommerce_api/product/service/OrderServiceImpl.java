package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.custom.AddressNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.custom.OrderNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.custom.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.model.mapper.OrderMapper;
import com.itortosagimeno.ecommerce_api.product.model.mapper.OrderProductMapper;
import com.itortosagimeno.ecommerce_api.product.repository.OrderProductRepository;
import com.itortosagimeno.ecommerce_api.product.repository.OrderRepository;
import com.itortosagimeno.ecommerce_api.user.repository.AddressRepository;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            OrderProductRepository orderProductRepository,
            AddressRepository addressRepository,
            UserRepository userRepository
    ) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
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
        final var exists = addressRepository.existsById(addressId);
        if (!exists) throw new AddressNotFoundException(addressId);
        return orderRepository.findAllByAddressId(addressId)
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public List<OrderResponse> getOrdersByUserId(final Integer userId) {
        final var exists = userRepository.existsById(userId);
        if (!exists) throw new UserNotFoundException(userId);
        return orderRepository.findAllByUserId(userId)
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public OrderResponse getOrderById(final Integer id) {
        final var exists = orderRepository.existsById(id);
        if (!exists) throw new OrderNotFoundException(id);
        return orderRepository.findById(id)
                .map(OrderMapper::toResponse)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Transactional
    @Override
    public OrderResponse insertOrder(OrderRequest orderRequest) {
        final var addressExists = addressRepository.existsById(orderRequest.addressId());
        if (!addressExists) throw new AddressNotFoundException(orderRequest.addressId());
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
