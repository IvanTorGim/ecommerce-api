package com.itortosagimeno.ecommerce_api.product.repository;

import com.itortosagimeno.ecommerce_api.product.model.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Integer> {
}