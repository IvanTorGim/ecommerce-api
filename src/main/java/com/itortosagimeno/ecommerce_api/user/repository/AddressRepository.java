package com.itortosagimeno.ecommerce_api.user.repository;

import com.itortosagimeno.ecommerce_api.user.model.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    List<AddressEntity> findAllByUserId(Integer userId);
}