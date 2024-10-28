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
        return ProductEntity.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .category(dto.category())
                .image(dto.image())
                .stock(dto.stock())
                .build();
    }

    public static ProductEntity toEntityWithId(Integer id, ProductRequestDTO dto) {
        return ProductEntity.builder()
                .id(id)
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .category(dto.category())
                .image(dto.image())
                .stock(dto.stock())
                .build();
    }
}
