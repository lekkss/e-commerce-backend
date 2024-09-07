package com.lekkss.ecommerce.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PaymentDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer orderId;
    private BigDecimal amount;
    private String provider;
    private String status;
    @OneToOne(mappedBy = "paymentDetails")
    private OrderDetails orderDetails;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
