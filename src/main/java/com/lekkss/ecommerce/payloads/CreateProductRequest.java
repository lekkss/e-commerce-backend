package com.lekkss.ecommerce.payloads;

import com.lekkss.ecommerce.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {
    private ProductDto product;
    private Integer quantity;
}
