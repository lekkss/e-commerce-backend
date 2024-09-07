package com.lekkss.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserAddressDto {
    private Integer id;
    private Integer userId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String country;
    private String phone;
    private String mobile;
}
