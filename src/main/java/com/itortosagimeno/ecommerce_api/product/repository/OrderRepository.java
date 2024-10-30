package com.itortosagimeno.ecommerce_api.product.repository;

import com.itortosagimeno.ecommerce_api.product.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
