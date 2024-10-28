package com.itortosagimeno.ecommerce_api.product.model;

public class ProductMapper {

    public static ProductResponse toResponse(ProductEntity entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .image(entity.getImage())
                .stock(entity.getStock())
                .build();
    }

    public static ProductEntity toEntity(ProductRequest request) {
        return ProductEntity.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .category(request.category())
                .image(request.image())
                .stock(request.stock())
                .build();
    }

    public static ProductEntity toEntityWithId(Integer id, ProductRequest request) {
        return ProductEntity.builder()
                .id(id)
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .category(request.category())
                .image(request.image())
                .stock(request.stock())
                .build();
    }
}
