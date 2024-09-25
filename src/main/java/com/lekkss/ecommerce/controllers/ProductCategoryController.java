package com.lekkss.ecommerce.controllers;

import com.lekkss.ecommerce.dto.ProductCategoryDto;
import com.lekkss.ecommerce.payloads.APIResponse;
import com.lekkss.ecommerce.services.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_categories")
@AllArgsConstructor
public class ProductCategoryController {

    private  ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<APIResponse<ProductCategoryDto>> create(@RequestBody ProductCategoryDto productCategory) {
        APIResponse<ProductCategoryDto> apiResponse = new APIResponse<>();
        try {
           ProductCategoryDto productCategoryDto =  productCategoryService.addProductCategory(productCategory);
           apiResponse.setData(productCategoryDto);
            apiResponse.setMessage("Product category created");
        }
        catch (Exception e) {
            apiResponse.setMessage("error creating category");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ProductCategoryDto>>> getAll() {
        APIResponse<List<ProductCategoryDto>> apiResponse = new APIResponse<>();
        try {
           List<ProductCategoryDto> productCategories = productCategoryService.getAllProductCategories();
           apiResponse.setData(productCategories);
           apiResponse.setMessage("Product category list");
        }
        catch (Exception e) {
            apiResponse.setMessage("error retrieving categories");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse<Void>> delete(@PathVariable Integer id) {
        APIResponse<Void> apiResponse = new APIResponse<>();
        try {
            productCategoryService.deleteProductCategory(id);
            apiResponse.setMessage("Product category deleted");
        }
        catch (Exception e) {
            apiResponse.setMessage("error deleting category");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<APIResponse<ProductCategoryDto>> update(@PathVariable Integer id, @RequestBody ProductCategoryDto productCategory) {
        APIResponse<ProductCategoryDto> apiResponse = new APIResponse<>();
        try {
            ProductCategoryDto productCategoryDto = productCategoryService.updateProductCategory(productCategory, id);
            apiResponse.setData(productCategoryDto);
            apiResponse.setMessage("Product category updated");
        }
        catch (Exception e) {
            apiResponse.setMessage("error updating category");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
