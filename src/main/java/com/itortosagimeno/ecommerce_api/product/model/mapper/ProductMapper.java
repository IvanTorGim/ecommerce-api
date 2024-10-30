package com.itortosagimeno.ecommerce_api.product.model.mapper;

import com.itortosagimeno.ecommerce_api.product.model.dto.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.ProductResponse;
import com.itortosagimeno.ecommerce_api.product.model.entity.ProductEntity;

public class ProductMapper {

    public static ProductResponse toResponse(ProductEntity entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCategory(),
                entity.getImage(),
                entity.getStock()
        );
    }

    public static ProductEntity toEntity(ProductRequest request) {
        return new ProductEntity(
                request.name(),
                request.description(),
                request.price(),
                request.image(),
                request.stock(),
                request.category()
        );
    }

    public static ProductEntity toEntity(ProductRequest request, ProductEntity entity) {
        entity.setName(request.name());
        entity.setDescription(request.description());
        entity.setPrice(request.price());
        entity.setCategory(request.category());
        entity.setImage(request.image());
        entity.setStock(request.stock());
        return entity;
    }
}
