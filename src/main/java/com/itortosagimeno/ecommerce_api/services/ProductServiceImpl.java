package com.itortosagimeno.ecommerce_api.services;

import com.itortosagimeno.ecommerce_api.exceptions.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.models.dtos.ProductDTO;
import com.itortosagimeno.ecommerce_api.models.entities.ProductEntity;
import com.itortosagimeno.ecommerce_api.models.mappers.ProductMapper;
import com.itortosagimeno.ecommerce_api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    @Override
    public ProductDTO getProductById(final Integer id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductDTO insertProduct(ProductDTO productDTO) {
        ProductEntity entity = ProductMapper.toEntity(productDTO);
        ProductEntity saved = productRepository.save(entity);
        return ProductMapper.toDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) throws ProductNotFoundException {
        boolean exists = productRepository.existsById(id);
        if(!exists) throw new ProductNotFoundException(id);
        ProductEntity entityMapped = ProductMapper.toEntityWithId(id, productDTO);
        ProductEntity saved = productRepository.save(entityMapped);
        return ProductMapper.toDTO(saved);
    }

    @Override
    public void deleteProduct(Integer id) throws ProductNotFoundException {
        boolean exists = productRepository.existsById(id);
        if (!exists) throw new ProductNotFoundException(id);
        productRepository.deleteById(id);
    }

}
