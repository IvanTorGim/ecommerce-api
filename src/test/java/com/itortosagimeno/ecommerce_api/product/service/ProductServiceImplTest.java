package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.Category;
import com.itortosagimeno.ecommerce_api.product.model.ProductEntity;
import com.itortosagimeno.ecommerce_api.product.model.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.itortosagimeno.ecommerce_api.product.service.ProductServiceDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testGetAllProducts() {
        final var expected = productResponseList();
        final var mockProducts = productEntityList();
        when(productRepository.findAll()).thenReturn(mockProducts);
        final var actual = productService.getAllProducts();
        assertIterableEquals(expected, actual);
        verify(productRepository).findAll();
    }

    @Test
    void testGetProductById() {
        final var expected = productResponse();
        final var mock = productEntity();
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(mock));
        final var actual = productService.getProductById(anyInt());
        assertEquals(expected, actual);
        verify(productRepository).findById(anyInt());
    }

    @Test
    void testGetProductByIdThrowsProductNotFoundException() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> productService.getProductById(anyInt()));
        verify(productRepository).findById(anyInt());
    }

    @Test
    void testInsertProduct() {
        final var expected = productResponse();
        final var mock = productEntity();
        when(productRepository.save(any(ProductEntity.class))).thenReturn(mock);
        final var request = productRequest();
        final var actual = productService.insertProduct(request);
        assertEquals(expected, actual);
        verify(productRepository).save(any(ProductEntity.class));
    }

    @Test
    void testUpdateProduct() {
        final var expected = productResponse();
        ProductEntity mock = productEntity();
        final var optional = optionalProductEntity();
        when(productRepository.findById(any())).thenReturn(optional);
        when(productRepository.save(any(ProductEntity.class))).thenReturn(mock);
        final var request = productRequest();
        final var actual = productService.updateProduct(3, request);
        assertEquals(expected, actual);
        verify(productRepository).findById(anyInt());
        verify(productRepository).save(any(ProductEntity.class));
    }

    @Test
    void testUpdateProductThrowsProductNotFoundException() {
        when(productRepository.findById(any())).thenReturn(Optional.empty());
        final var request = new ProductRequest("product 3", "description 3", 3.0, Category.HOME, "image3.jpg", 3);
        assertThrows(ProductNotFoundException.class, () -> productService.updateProduct(anyInt(), request));
        verify(productRepository).findById(anyInt());
        verify(productRepository, times(0)).save(any(ProductEntity.class));
    }

    @Test
    void testDeleteProduct() {
        when(productRepository.existsById(anyInt())).thenReturn(true);
        productService.deleteProduct(anyInt());
        verify(productRepository).existsById(anyInt());
        verify(productRepository).deleteById(anyInt());
    }

    @Test
    void testDeleteProductThrowsProductNotFoundException() throws ProductNotFoundException {
        when(productRepository.existsById(anyInt())).thenReturn(false);
        assertThrows(ProductNotFoundException.class, () -> productService.deleteProduct(anyInt()));
        verify(productRepository).existsById(anyInt());
        verify(productRepository, times(0)).deleteById(anyInt());
    }
}