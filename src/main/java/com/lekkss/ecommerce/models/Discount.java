package com.lekkss.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Discount {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private Double discountPercent;
    private Boolean active;
    @OneToMany(mappedBy = "discount")
    private List<Product> products;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
