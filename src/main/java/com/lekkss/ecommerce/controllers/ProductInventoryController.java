package com.lekkss.ecommerce.controllers;

import com.lekkss.ecommerce.dto.ProductInventoryDto;
import com.lekkss.ecommerce.payloads.APIResponse;
import com.lekkss.ecommerce.services.ProductInventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product_inventory")
@AllArgsConstructor
public class ProductInventoryController {
    private final ProductInventoryService productInventoryService;

    @PostMapping("{productId}")
    public ResponseEntity<APIResponse<ProductInventoryDto>> addProductInventory(@RequestBody  ProductInventoryDto productInventoryDto, @PathVariable Integer productId) {
        APIResponse<ProductInventoryDto> apiResponse = new APIResponse<>();
        try {
            ProductInventoryDto productInventory = productInventoryService.addProductInventory(productInventoryDto, productId);
            apiResponse.setData(productInventory);
            apiResponse.setMessage("Product inventory added successfully");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
        catch (Exception e) {
            apiResponse.setMessage("Error while adding product inventory");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponse<ProductInventoryDto>> getProductInventoryById(@PathVariable Integer id) {
        APIResponse<ProductInventoryDto> apiResponse = new APIResponse<>();
        try {
            ProductInventoryDto productInventoryDto = productInventoryService.getProductInventoryById(id);
            apiResponse.setData(productInventoryDto);
            apiResponse.setMessage("Product inventory retrieved successfully ");
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            apiResponse.setMessage("Error while getting product inventory");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<APIResponse<ProductInventoryDto>> updateProductInventory(
            @RequestBody ProductInventoryDto productInventoryDto,
            @PathVariable Integer id) {
        APIResponse<ProductInventoryDto> apiResponse = new APIResponse<>();
        try {
            ProductInventoryDto updatedInventory = productInventoryService.updateProductInventory(productInventoryDto,id);
            apiResponse.setData(updatedInventory);
            apiResponse.setMessage("Product inventory updated successfully");
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            apiResponse.setMessage("Error while updating product inventory");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
