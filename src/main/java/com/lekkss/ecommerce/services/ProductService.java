package com.lekkss.ecommerce.services;

import com.lekkss.ecommerce.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto, Integer categoryId);
    ProductDto updateProduct(ProductDto productDto, Integer productId);
    ProductDto getProductById(Integer productId);
    List<ProductDto> getProductsByCategoryId(Integer categoryId);
    List<ProductDto> getAllProducts();
    void deleteProduct(Integer productId);
}
