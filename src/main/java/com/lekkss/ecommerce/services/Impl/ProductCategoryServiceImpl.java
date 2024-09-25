package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.ProductCategoryDto;
import com.lekkss.ecommerce.exceptions.RecordNotFoundException;
import com.lekkss.ecommerce.models.ProductCategory;
import com.lekkss.ecommerce.repositories.ProductCategoryRepository;
import com.lekkss.ecommerce.services.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {


    private ProductCategoryRepository productCategoryRepository;
    private ModelMapper modelMapper;



    @Override
    public ProductCategoryDto addProductCategory(ProductCategoryDto productCategoryDto) {
        //convert categoryDto to category
        ProductCategory productCategory = modelMapper.map(productCategoryDto, ProductCategory.class);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return modelMapper.map(savedProductCategory, ProductCategoryDto.class);
    }

    @Override
    public void deleteProductCategory(Integer id) {
        ProductCategory productCategory = productCategoryRepository
                .findById(id).orElseThrow(()-> new RecordNotFoundException("ProductCategory", "id", id));
        productCategoryRepository.delete(productCategory);
    }

    @Override
    public ProductCategoryDto getProductCategoryById(Integer id) {
        ProductCategory productCategory = productCategoryRepository
                .findById(id).orElseThrow(()-> new RecordNotFoundException("ProductCategory", "id", id));
        return modelMapper.map(productCategory, ProductCategoryDto.class);
    }

    @Override
    public List<ProductCategoryDto> getAllProductCategories() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        return  productCategories.stream()
                .map(productCategory -> modelMapper
                        .map(productCategory, ProductCategoryDto.class))
                .collect(Collectors
                        .toList());
    }

    @Override
    public ProductCategoryDto updateProductCategory(ProductCategoryDto productCategoryDto, Integer id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).
                orElseThrow(() -> new RecordNotFoundException("ProductCategory", "id",id));
        productCategory.setName(productCategoryDto.getName());
        productCategory.setDescription(productCategoryDto.getDescription());
        ProductCategory updatedProductCategory = productCategoryRepository.save(productCategory);
        return modelMapper.map(updatedProductCategory, ProductCategoryDto.class);
    }
}
