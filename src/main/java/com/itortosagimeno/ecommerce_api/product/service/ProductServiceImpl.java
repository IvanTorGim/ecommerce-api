package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.ProductMapper;
import com.itortosagimeno.ecommerce_api.product.model.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.ProductResponse;
import com.itortosagimeno.ecommerce_api.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(final Integer id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .map(ProductMapper::toResponse)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductResponse insertProduct(final ProductRequest productDTO) {
        final var entity = ProductMapper.toEntity(productDTO);
        final var saved = productRepository.save(entity);
        return ProductMapper.toResponse(saved);
    }

    @Override
    public ProductResponse updateProduct(final Integer id, final ProductRequest productDTO) throws ProductNotFoundException {
        final var exists = productRepository.existsById(id);
        if (!exists) throw new ProductNotFoundException(id);
        final var entityMapped = ProductMapper.toEntityWithId(id, productDTO);
        final var saved = productRepository.save(entityMapped);
        return ProductMapper.toResponse(saved);
    }

    @Override
    public void deleteProduct(final Integer id) throws ProductNotFoundException {
        var exists = productRepository.existsById(id);
        if (!exists) throw new ProductNotFoundException(id);
        productRepository.deleteById(id);
    }

}
