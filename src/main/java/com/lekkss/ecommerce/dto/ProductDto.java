package com.lekkss.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String sku;
    private ProductCategoryDto productCategory;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
