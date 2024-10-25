package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.ProductRequestDTO;
import com.itortosagimeno.ecommerce_api.product.model.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Integer id) throws ProductNotFoundException;

    ProductResponseDTO insertProduct(ProductRequestDTO productDTO);

    ProductResponseDTO updateProduct(Integer id, ProductRequestDTO productDTO) throws ProductNotFoundException;

    void deleteProduct(Integer id) throws ProductNotFoundException;
}
