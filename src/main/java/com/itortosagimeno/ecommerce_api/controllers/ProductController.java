package com.itortosagimeno.ecommerce_api.controllers;

import com.itortosagimeno.ecommerce_api.exceptions.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.models.dtos.ProductDTO;
import com.itortosagimeno.ecommerce_api.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        final List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity
                .ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(
            @PathVariable("id") final Integer id
    ) throws ProductNotFoundException {
        final ProductDTO product = productService.getProductById(id);
        return ResponseEntity
                .ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insertProduct(@Valid @RequestBody ProductDTO productDTO) {
        final ProductDTO product = productService.insertProduct(productDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable final Integer id,
            @Valid @RequestBody ProductDTO productDTO
    ) throws ProductNotFoundException {
        final ProductDTO product = productService.updateProduct(id, productDTO);
        return ResponseEntity
                .ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Integer id
    ) throws ProductNotFoundException{
        productService.deleteProduct(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}