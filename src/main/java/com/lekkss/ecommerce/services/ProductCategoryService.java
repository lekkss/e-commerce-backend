package com.lekkss.ecommerce.services;

import com.lekkss.ecommerce.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {
    ProductCategoryDto addProductCategory(ProductCategoryDto productCategoryDto);
    void deleteProductCategory(Integer id);
    ProductCategoryDto getProductCategoryById(Integer id);
    List<ProductCategoryDto> getAllProductCategories();
    ProductCategoryDto updateProductCategory(ProductCategoryDto productCategoryDto, Integer id);
}
