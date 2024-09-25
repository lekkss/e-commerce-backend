package com.lekkss.ecommerce.repositories;

import com.lekkss.ecommerce.models.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Integer> {
}
