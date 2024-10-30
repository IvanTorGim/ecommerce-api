package com.itortosagimeno.ecommerce_api.product.repository;

import com.itortosagimeno.ecommerce_api.product.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByAddressId(Integer userId);
}
