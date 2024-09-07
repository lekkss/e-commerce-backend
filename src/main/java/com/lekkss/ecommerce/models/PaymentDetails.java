package com.lekkss.ecommerce.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PaymentDetails extends BaseEntity {
    private Integer orderId;
    private BigDecimal amount;
    private String provider;
    private String status;
    @OneToOne(mappedBy = "paymentDetails")
    private OrderDetails orderDetails ;
}
