package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.product.model.common.Category;
import com.itortosagimeno.ecommerce_api.product.model.dto.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.ProductResponse;
import com.itortosagimeno.ecommerce_api.product.model.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public class ProductServiceDataProvider {

    protected static List<ProductResponse> productResponseList() {
        return List.of(
                new ProductResponse(
                        1,
                        "product 1",
                        "description 1",
                        1.0,
                        Category.AUDIO,
                        "image1.jpg", 1
                ),
                new ProductResponse(
                        2,
                        "product 2",
                        "description 2",
                        2.0,
                        Category.ACCESSORIES,
                        "image2.jpg", 2
                )
        );
    }

    protected static List<ProductEntity> productEntityList() {
        return List.of(
                new ProductEntity(
                        1,
                        "product 1",
                        "description 1",
                        1.0,
                        "image1.jpg",
                        1,
                        Category.AUDIO
                ),
                new ProductEntity(
                        2,
                        "product 2",
                        "description 2",
                        2.0,
                        "image2.jpg",
                        2,
                        Category.ACCESSORIES
                )
        );
    }

    protected static ProductResponse productResponse() {
        return new ProductResponse(
                3,
                "product 3",
                "description 3",
                3.0,
                Category.HOME,
                "image3.jpg",
                3
        );
    }

    protected static ProductEntity productEntity() {
        return new ProductEntity(
                3,
                "product 3",
                "description 3",
                3.0,
                "image3.jpg",
                3,
                Category.HOME
        );
    }

    protected static ProductRequest productRequest() {
        return new ProductRequest(
                "product 3",
                "description 3",
                3.0,
                Category.HOME,
                "image3.jpg",
                3
        );
    }

    protected static Optional<ProductEntity> optionalProductEntity() {
        return Optional.of(
                new ProductEntity(
                        3,
                        "Product 4",
                        "description 4",
                        4.0,
                        "image4.jpg",
                        4,
                        Category.AUDIO
                )
        );
    }
}
