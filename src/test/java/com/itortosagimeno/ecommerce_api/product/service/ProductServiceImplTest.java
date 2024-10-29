package com.itortosagimeno.ecommerce_api.product.service;

import com.itortosagimeno.ecommerce_api.exception.ProductNotFoundException;
import com.itortosagimeno.ecommerce_api.product.model.Category;
import com.itortosagimeno.ecommerce_api.product.model.ProductEntity;
import com.itortosagimeno.ecommerce_api.product.model.ProductRequest;
import com.itortosagimeno.ecommerce_api.product.model.ProductResponse;
import com.itortosagimeno.ecommerce_api.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

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
        List<ProductResponse> expected = List.of(
                new ProductResponse(1, "product 1", "description 1", 1.0, Category.AUDIO, "image1.jpg", 1),
                new ProductResponse(2, "product 2", "description 2", 2.0, Category.ACCESSORIES, "image2.jpg", 2)
        );
        List<ProductEntity> mockProducts = List.of(
                new ProductEntity(1, "product 1", "description 1", 1.0, "image1.jpg", 1, Category.AUDIO),
                new ProductEntity(2, "product 2", "description 2", 2.0, "image2.jpg", 2, Category.ACCESSORIES)
        );
        when(productRepository.findAll()).thenReturn(mockProducts);
        List<ProductResponse> actual = productService.getAllProducts();
        assertIterableEquals(expected, actual);
        verify(productRepository).findAll();
    }

    @Test
    void testGetProductById() throws ProductNotFoundException {
        ProductResponse expected =
                new ProductResponse(3, "product 3", "description 3", 3.0, Category.HOME, "image3.jpg", 3);
        ProductEntity mock =
                new ProductEntity(3, "product 3", "description 3", 3.0, "image3.jpg", 3, Category.HOME);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(mock));
        ProductResponse actual = productService.getProductById(anyInt());
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
        ProductResponse expected =
                new ProductResponse(3, "product 3", "description 3", 3.0, Category.HOME, "image3.jpg", 3);
        ProductEntity mock =
                new ProductEntity(3, "product 3", "description 3", 3.0, "image3.jpg", 3, Category.HOME);
        when(productRepository.save(any(ProductEntity.class))).thenReturn(mock);
        ProductRequest request = new ProductRequest("product 3", "description 3", 3.0, Category.HOME, "image3.jpg", 3);
        ProductResponse actual = productService.insertProduct(request);
        assertEquals(expected, actual);
        verify(productRepository).save(any(ProductEntity.class));
    }

    @Test
    void testUpdateProduct() throws ProductNotFoundException {
        ProductResponse expected =
                new ProductResponse(3, "product 3", "description 3", 3.0, Category.HOME, "image3.jpg", 3);
        ProductEntity mock =
                new ProductEntity(3, "product 3", "description 3", 3.0, "image3.jpg", 3, Category.HOME);
        ProductEntity find =
                new ProductEntity(3, "product 4", "description 4", 4.0, "image4.jpg", 4, Category.AUDIO);
        when(productRepository.findById(any())).thenReturn(Optional.of(find));
        when(productRepository.save(any(ProductEntity.class))).thenReturn(mock);
        ProductRequest request = new ProductRequest("product 3", "description 3", 3.0, Category.HOME, "image3.jpg", 3);
        ProductResponse actual = productService.updateProduct(3, request);
        assertEquals(expected, actual);
        verify(productRepository).findById(anyInt());
        verify(productRepository).save(any(ProductEntity.class));
    }

    @Test
    void testUpdateProductThrowsProductNotFoundException() {
        when(productRepository.findById(any())).thenReturn(Optional.empty());
        ProductRequest request = new ProductRequest("product 3", "description 3", 3.0, Category.HOME, "image3.jpg", 3);
        assertThrows(ProductNotFoundException.class, () -> productService.updateProduct(anyInt(), request));
        verify(productRepository).findById(anyInt());
        verify(productRepository, times(0)).save(any(ProductEntity.class));
    }

    @Test
    void testDeleteProduct() throws ProductNotFoundException {
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