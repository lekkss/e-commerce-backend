package com.lekkss.ecommerce.services;

import com.lekkss.ecommerce.dto.ProductInventoryDto;

public interface ProductInventoryService {
    ProductInventoryDto addProductInventory(ProductInventoryDto productInventoryDto, Integer productId);
    ProductInventoryDto updateProductInventory(ProductInventoryDto productInventoryDto, Integer id);
    ProductInventoryDto getProductInventoryById(Integer id);
}
