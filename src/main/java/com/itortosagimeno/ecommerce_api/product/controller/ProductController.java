package com.itortosagimeno.ecommerce_api.product.controller;

import com.itortosagimeno.ecommerce_api.exception.model.ApiException;
import com.itortosagimeno.ecommerce_api.product.model.dto.OrderResponse;
import com.itortosagimeno.ecommerce_api.product.model.dto.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.dto.ProductResponse;
import com.itortosagimeno.ecommerce_api.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Products", description = "Endpoints for products operations")
@RestController
@RequestMapping("/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Retrieve all products", description = "Returns a list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of products retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))
            ),
    })
    @GetMapping("/public/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        final var products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Retrieve products by product ID", description = "Returns a the details of a specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product for the ID retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @GetMapping("/public/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") final Integer id) {
        final var product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Create a new product", description = "Creates a new product based on the provided product details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class)))
    })
    @PostMapping("/private/products")
    public ResponseEntity<ProductResponse> insertProduct(@Valid @RequestBody final ProductRequest productRequest) {
        final var product = productService.insertProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }

    @Operation(summary = "Update product", description = "Update a product based on the provided ID and product details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @PutMapping("/private/products/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable final Integer id,
            @Valid @RequestBody final ProductRequest productRequest
    ) {
        final var product = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Delete a product by ID", description = "Deletes a product based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiException.class)))
    })
    @DeleteMapping("/private/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable final Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent()
                .build();
    }
}