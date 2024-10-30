package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.custom.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.dto.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.ProductResponse;
import com.itortosagimeno.ecommerce_api.product.model.mapper.ProductMapper;
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
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(final Integer id) {
        return productRepository.findById(id)
                .map(ProductMapper::toResponse)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductResponse insertProduct(final ProductRequest productRequest) {
        final var entity = ProductMapper.toEntity(productRequest);
        final var saved = productRepository.save(entity);
        return ProductMapper.toResponse(saved);
    }

    @Override
    public ProductResponse updateProduct(final Integer id, final ProductRequest productRequest) {
        final var productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) throw new ProductNotFoundException(id);
        final var entity = ProductMapper.toEntity(productRequest, productOptional.get());
        final var saved = productRepository.save(entity);
        return ProductMapper.toResponse(saved);
    }

    @Override
    public void deleteProduct(final Integer id) {
        var exists = productRepository.existsById(id);
        if (!exists) throw new ProductNotFoundException(id);
        productRepository.deleteById(id);
    }

}
