package com.lekkss.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "user")
    private List<UserAddress> addresses;
    @OneToMany(mappedBy = "user")
    private List<UserPayment> payments;
    @OneToOne(mappedBy = "user")
    private ShoppingSession session;
    @OneToOne(mappedBy = "user")
    private OrderDetails orderDetails;
}
