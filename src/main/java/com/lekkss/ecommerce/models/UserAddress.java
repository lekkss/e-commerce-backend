package com.lekkss.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity
public class UserAddress {
    @Id
    @GeneratedValue
    private Integer id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String country;
    private String phone;
    private String mobile;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
