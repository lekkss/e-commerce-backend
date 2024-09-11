package com.lekkss.ecommerce.repositories;

import com.lekkss.ecommerce.models.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
    List<UserAddress> findByUserId(Integer userId);
}
