package com.itortosagimeno.ecommerce_api.product.controller;

import com.itortosagimeno.ecommerce_api.exception.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.ProductRequestDTO;
import com.itortosagimeno.ecommerce_api.product.model.ProductResponseDTO;
import com.itortosagimeno.ecommerce_api.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/public/products")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        final var products = productService.getAllProducts();
        return ResponseEntity
                .ok(products);
    }

    @GetMapping("/public/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(
            @PathVariable("id") final Integer id
    ) throws ProductNotFoundException {
        final var product = productService.getProductById(id);
        return ResponseEntity
                .ok(product);
    }

    @PostMapping("/private/products")
    public ResponseEntity<ProductResponseDTO> insertProduct(
            @Valid @RequestBody final ProductRequestDTO productDTO
    ) {
        final var product = productService.insertProduct(productDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @PutMapping("/private/products/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable final Integer id,
            @Valid @RequestBody final ProductRequestDTO productDTO
    ) throws ProductNotFoundException {
        final var product = productService.updateProduct(id, productDTO);
        return ResponseEntity
                .ok(product);
    }

    @DeleteMapping("/private/products/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable final Integer id
    ) throws ProductNotFoundException {
        productService.deleteProduct(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}