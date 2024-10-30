package com.itortosagimeno.ecommerce_api.product.controller;

import com.itortosagimeno.ecommerce_api.exception.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.ProductResponse;
import com.itortosagimeno.ecommerce_api.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/public/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        final var products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/public/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable("id") final Integer id
    ) throws ProductNotFoundException {
        final var product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/private/products")
    public ResponseEntity<ProductResponse> insertProduct(
            @Valid @RequestBody final ProductRequest productRequest
    ) {
        final var product = productService.insertProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }

    @PutMapping("/private/products/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable final Integer id,
            @Valid @RequestBody final ProductRequest productRequest
    ) throws ProductNotFoundException {
        final var product = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/private/products/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable final Integer id
    ) throws ProductNotFoundException {
        productService.deleteProduct(id);
        return ResponseEntity.noContent()
                .build();
    }
}