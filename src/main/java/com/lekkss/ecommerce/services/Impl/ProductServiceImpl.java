package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.ProductDto;
import com.lekkss.ecommerce.exceptions.RecordNotFoundException;
import com.lekkss.ecommerce.models.Product;
import com.lekkss.ecommerce.models.ProductCategory;
import com.lekkss.ecommerce.models.ProductInventory;
import com.lekkss.ecommerce.repositories.ProductCategoryRepository;
import com.lekkss.ecommerce.repositories.ProductInventoryRepository;
import com.lekkss.ecommerce.repositories.ProductRepository;
import com.lekkss.ecommerce.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;
    private ProductInventoryRepository productInventoryRepository;
    private ModelMapper modelMapper;


    @Override
    public ProductDto addProduct(ProductDto productDto, Integer categoryId) {
        // Fetch the category using the categoryId
        ProductCategory category = productCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RecordNotFoundException("ProductCategory", "CategoryId", categoryId));

        // Map ProductDto to Product entity
        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        // Save the product to get the generated product ID
        Product savedProduct = productRepository.save(product);

        // Create ProductInventory using the quantity from ProductDto
        ProductInventory productInventory = new ProductInventory();
        productInventory.setProduct(savedProduct);
        productInventory.setQuantity(productDto.getQuantity()); // Get quantity from ProductDto
        productInventory.setCreatedAt(LocalDateTime.now());
        productInventory.setUpdatedAt(LocalDateTime.now());

        // Save the product inventory and link it to the product
        ProductInventory savedInventory = productInventoryRepository.save(productInventory);

        // Link the saved inventory back to the saved product
        savedProduct.setInventory(savedInventory);

        // Update the product with the inventory reference
        productRepository.save(savedProduct);

        // Map the saved product (with inventory) back to ProductDto and return
        return modelMapper.map(savedProduct, ProductDto.class);
    }


    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {
       Product product = productRepository.findById(productId)
               .orElseThrow(() -> new RecordNotFoundException("Product", "ProductId", productId));
       product.setUpdatedAt(LocalDateTime.now());
       product.setName(productDto.getName());
       product.setDescription(productDto.getDescription());
       product.setSKU(productDto.getSku());
       product.setPrice(productDto.getPrice());
       Product updatedProduct = productRepository.save(product);
       return modelMapper.map(updatedProduct, ProductDto.class);
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RecordNotFoundException("Product", "ProductId", productId));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> {
            // Map Product entity to ProductDto
            ProductDto productDto = modelMapper.map(product, ProductDto.class);

            // Fetch the quantity from the associated ProductInventory
            if (product.getInventory() != null) {
                productDto.setQuantity(product.getInventory().getQuantity());
            } else {
                productDto.setQuantity(0); // Default to 0 if no inventory exists
            }

            return productDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RecordNotFoundException("Product", "ProductId", productId));
        productRepository.delete(product);
    }
}
