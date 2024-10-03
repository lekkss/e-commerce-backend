package com.lekkss.ecommerce.controllers;

import com.lekkss.ecommerce.dto.ProductDto;
import com.lekkss.ecommerce.dto.ProductInventoryDto;
import com.lekkss.ecommerce.payloads.APIResponse;
import com.lekkss.ecommerce.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("{categoryId}")
    public ResponseEntity<APIResponse<ProductDto>> createProduct(@RequestBody ProductDto productDto, @PathVariable Integer categoryId) {
        APIResponse<ProductDto> apiResponse = new APIResponse<>();
        try {
            ProductDto saved = productService.addProduct(productDto, categoryId);
            apiResponse.setData(saved);
            apiResponse.setMessage("Product created");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
        catch (Exception e) {
            apiResponse.setMessage("Error while creating product " + e.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ProductDto>>> getProducts() {
        APIResponse<List<ProductDto>> apiResponse = new APIResponse<>();
        try {
            List<ProductDto> products = productService.getAllProducts();
            apiResponse.setData(products);
            apiResponse.setMessage("Product list");
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            apiResponse.setMessage("Error while getting products");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<APIResponse<ProductDto>> updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        APIResponse<ProductDto> apiResponse = new APIResponse<>();
        try {
        ProductDto product = productService.updateProduct(productDto, id);
        apiResponse.setData(product);
        apiResponse.setMessage("Product updated" + productDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            apiResponse.setMessage("Error while updating product " + e.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse<Void>> deleteProduct(@PathVariable Integer id) {
        APIResponse<Void> apiResponse = new APIResponse<>();
        try {
            productService.deleteProduct(id);
            apiResponse.setMessage("Product deleted");
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            apiResponse.setMessage("Error while deleting product " + e.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
