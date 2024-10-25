package com.itortosagimeno.ecommerce_api.product.model;

public class ProductMapper {

    public static ProductResponseDTO toDTO(ProductEntity entity) {
        return ProductResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .image(entity.getImage())
                .stock(entity.getStock())
                .build();
    }

    public static ProductEntity toEntity(ProductRequestDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.setCategory(dto.category());
        entity.setImage(dto.image());
        entity.setStock(dto.stock());
        return entity;
    }

    public static ProductEntity toEntityWithId(Integer id, ProductRequestDTO dto) {
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
