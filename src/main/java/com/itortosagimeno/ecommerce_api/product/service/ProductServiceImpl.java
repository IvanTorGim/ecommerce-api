package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.ProductMapper;
import com.itortosagimeno.ecommerce_api.product.model.ProductRequestDTO;
import com.itortosagimeno.ecommerce_api.product.model.ProductResponseDTO;
import com.itortosagimeno.ecommerce_api.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(final Integer id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductResponseDTO insertProduct(final ProductRequestDTO productDTO) {
        final var entity = ProductMapper.toEntity(productDTO);
        final var saved = productRepository.save(entity);
        return ProductMapper.toDTO(saved);
    }

    @Override
    public ProductResponseDTO updateProduct(final Integer id, final ProductRequestDTO productDTO) throws ProductNotFoundException {
        final var exists = productRepository.existsById(id);
        if (!exists) throw new ProductNotFoundException(id);
        final var entityMapped = ProductMapper.toEntityWithId(id, productDTO);
        final var saved = productRepository.save(entityMapped);
        return ProductMapper.toDTO(saved);
    }

    @Override
    public void deleteProduct(final Integer id) throws ProductNotFoundException {
        var exists = productRepository.existsById(id);
        if (!exists) throw new ProductNotFoundException(id);
        productRepository.deleteById(id);
    }

}
