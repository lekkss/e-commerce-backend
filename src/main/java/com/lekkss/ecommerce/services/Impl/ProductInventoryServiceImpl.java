package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.ProductInventoryDto;
import com.lekkss.ecommerce.exceptions.RecordNotFoundException;
import com.lekkss.ecommerce.models.Product;
import com.lekkss.ecommerce.models.ProductInventory;
import com.lekkss.ecommerce.repositories.ProductInventoryRepository;
import com.lekkss.ecommerce.repositories.ProductRepository;
import com.lekkss.ecommerce.services.ProductInventoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductInventoryServiceImpl implements ProductInventoryService {
    private final ProductInventoryRepository productInventoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Override
    public ProductInventoryDto addProductInventory(ProductInventoryDto productInventoryDto, Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RecordNotFoundException("ProductInventory", "productId", productId));
        ProductInventory productInventory = modelMapper.map(productInventoryDto, ProductInventory.class);
        productInventory.setProduct(product);
        productInventory.setCreatedAt(LocalDateTime.now());
        ProductInventory savedProductInventory = productInventoryRepository.save(productInventory);
        return modelMapper.map(savedProductInventory, ProductInventoryDto.class);
    }

    @Override
    public ProductInventoryDto updateProductInventory(ProductInventoryDto productInventoryDto, Integer id) {
        // Fetch the existing inventory item, assuming 'id' refers to the specific inventory record
        ProductInventory existingInventory = productInventoryRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("ProductInventory", "id", id));

        // Update the quantity from the DTO
        existingInventory.setQuantity(productInventoryDto.getQuantity());

        // Update other fields, e.g., updatedAt
        existingInventory.setUpdatedAt(LocalDateTime.now());

        // Save the updated inventory item
        ProductInventory updatedInventory = productInventoryRepository.save(existingInventory);

        // Return the updated DTO
        return modelMapper.map(updatedInventory, ProductInventoryDto.class);
    }



    @Override
    public ProductInventoryDto getProductInventoryById(Integer id) {
        ProductInventory productInventory = productInventoryRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("ProductInventory", "id", id));

        // Ensure that the product is initialized before mapping
        if (productInventory.getProduct() != null) {
            productInventory.getProduct().getId(); // Trigger lazy loading if necessary
        }

        return modelMapper.map(productInventory, ProductInventoryDto.class);
    }

}
