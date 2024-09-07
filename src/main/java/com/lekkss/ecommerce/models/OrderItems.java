package com.lekkss.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderItems {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "orde_id")
    private OrderDetails orderDetails;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
