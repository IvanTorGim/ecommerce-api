package com.itortosagimeno.ecommerce_api.models.mappers;

import com.itortosagimeno.ecommerce_api.models.dtos.ProductDTO;
import com.itortosagimeno.ecommerce_api.models.entities.ProductEntity;

public class ProductMapper {

    public static ProductDTO toDTO(ProductEntity entity){
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCategory(),
                entity.getImage(),
                entity.getStock()
        );
    }

    public static ProductEntity toEntity(ProductDTO dto){
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setCategory(dto.category());
        entity.setImage(dto.image());
        entity.setStock(dto.stock());
        return entity;
    }

    public static ProductEntity toEntityWithId(Integer id, ProductDTO dto){
        ProductEntity entity = new ProductEntity();
        entity.setId(id);
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setCategory(dto.category());
        entity.setImage(dto.image());
        entity.setStock(dto.stock());
        return entity;
    }
}
