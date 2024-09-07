package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.UserAddressDto;
import com.lekkss.ecommerce.models.UserAddress;
import com.lekkss.ecommerce.repositories.UserAddressRepository;
import com.lekkss.ecommerce.services.UserAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserAddressDto addAddress(UserAddressDto userAddressDto) {
        UserAddress address = modelMapper.map(userAddressDto, UserAddress.class);
        UserAddress savedAddress = userAddressRepository.save(address);
        return modelMapper.map(savedAddress, UserAddressDto.class);
    }
}
