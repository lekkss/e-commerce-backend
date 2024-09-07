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
public class Product extends BaseEntity {
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

}
