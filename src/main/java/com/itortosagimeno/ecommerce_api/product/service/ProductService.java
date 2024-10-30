package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.product.model.dto.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Integer id);

    ProductResponse insertProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Integer id, ProductRequest productRequest);

    void deleteProduct(Integer id);
}
