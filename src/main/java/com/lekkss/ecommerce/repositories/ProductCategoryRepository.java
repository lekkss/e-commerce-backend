package com.lekkss.ecommerce.repositories;

import com.lekkss.ecommerce.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
