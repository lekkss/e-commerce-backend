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
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String SKU;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
    @OneToOne
    @JoinColumn(name="inventory_id")
    private ProductInventory inventory;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @OneToOne(mappedBy = "product")
    private CartItem cartItem;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
