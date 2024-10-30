package com.itortosagimeno.ecommerce_api.product.model.dto;


import com.itortosagimeno.ecommerce_api.product.model.common.Category;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Double price,
        Category category,
        String image,
        Integer stock
) {
}
