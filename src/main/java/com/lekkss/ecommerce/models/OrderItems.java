package com.lekkss.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderItems extends BaseEntity {
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "orde_id")
    private OrderDetails orderDetails;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
