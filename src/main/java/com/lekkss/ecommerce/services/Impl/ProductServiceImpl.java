package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.ProductDto;
import com.lekkss.ecommerce.exceptions.RecordNotFoundException;
import com.lekkss.ecommerce.models.Product;
import com.lekkss.ecommerce.models.ProductCategory;
import com.lekkss.ecommerce.repositories.ProductCategoryRepository;
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
    private ModelMapper modelMapper;


    @Override
    public ProductDto addProduct(ProductDto productDto, Integer categoryId) {
        ProductCategory category = productCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RecordNotFoundException("ProductCategory", "CategoryId", categoryId));
        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {
       Product product = productRepository.findById(productId)
               .orElseThrow(() -> new RecordNotFoundException("Product", "ProductId", productId));
       product.setUpdatedAt(LocalDateTime.now());
       product.setName(productDto.getName());
       product.setDescription(productDto.getDescription());
       product.setSKU(productDto.getSKU());
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
        return products.stream().map(product -> modelMapper
                .map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RecordNotFoundException("Product", "ProductId", productId));
        productRepository.delete(product);
    }
}
