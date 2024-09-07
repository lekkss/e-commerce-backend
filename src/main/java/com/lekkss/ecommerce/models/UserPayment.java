package com.lekkss.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserPayment {
    @Id
    @GeneratedValue
    private Integer id;
    private String paymentType;
    private String provider;
    private Integer accountNo;
    private Date expiry;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
