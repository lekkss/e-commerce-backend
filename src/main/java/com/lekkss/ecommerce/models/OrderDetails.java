package com.lekkss.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal total;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private PaymentDetails paymentDetails;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "orderDetails")
    private List<OrderItems> orderitems;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
