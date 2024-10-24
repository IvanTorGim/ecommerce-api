package com.itortosagimeno.ecommerce_api.services;

import com.itortosagimeno.ecommerce_api.exceptions.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.models.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Integer id) throws ProductNotFoundException;

    ProductDTO insertProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Integer id, ProductDTO productDTO) throws ProductNotFoundException;

    void deleteProduct(Integer id) throws ProductNotFoundException;
}
