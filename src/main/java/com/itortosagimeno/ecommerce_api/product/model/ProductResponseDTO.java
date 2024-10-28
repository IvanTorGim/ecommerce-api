package com.itortosagimeno.ecommerce_api.product.model;

import lombok.Builder;

@Builder
public record ProductResponseDTO(
        Integer id,
        String name,
        String description,
        Double price,
        Category category,
        String image,
        Integer stock
) {
}
