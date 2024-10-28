package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Integer id) throws ProductNotFoundException;

    ProductResponse insertProduct(ProductRequest productDTO);

    ProductResponse updateProduct(Integer id, ProductRequest productDTO) throws ProductNotFoundException;

    void deleteProduct(Integer id) throws ProductNotFoundException;
}
