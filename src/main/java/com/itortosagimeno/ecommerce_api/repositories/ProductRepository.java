package com.itortosagimeno.ecommerce_api.repositories;

import com.itortosagimeno.ecommerce_api.models.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
