package com.itortosagimeno.ecommerce_api.product.repository;

import com.itortosagimeno.ecommerce_api.product.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByAddressId(Integer addressId);

    @Query("SELECT o, a FROM OrderEntity o INNER JOIN AddressEntity a on o.address.id = a.id AND a.user.id = :userId")
    List<OrderEntity> findAllByUserId(@Param("userId") Integer userId);
}
