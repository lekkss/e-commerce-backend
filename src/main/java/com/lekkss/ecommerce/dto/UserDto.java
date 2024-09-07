package com.lekkss.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
}
