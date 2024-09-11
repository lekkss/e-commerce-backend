package com.lekkss.ecommerce.services;

import com.lekkss.ecommerce.dto.UserAddressDto;

import java.util.List;

public interface UserAddressService  {
    UserAddressDto addAddress(UserAddressDto userAddressDto);
    List<UserAddressDto> getAddressByUserId(Integer userId);
    List<UserAddressDto> getAllAddresses();
}
