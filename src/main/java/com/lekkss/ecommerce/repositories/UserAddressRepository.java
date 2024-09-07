package com.lekkss.ecommerce.repositories;

import com.lekkss.ecommerce.models.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
}
