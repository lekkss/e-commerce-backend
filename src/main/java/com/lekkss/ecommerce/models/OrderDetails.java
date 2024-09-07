package com.lekkss.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderDetails extends BaseEntity {
    private BigDecimal total;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private PaymentDetails paymentDetails;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "orderDetails")
    private List<OrderItems> orderitems;
}
