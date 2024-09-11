package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.UserAddressDto;
import com.lekkss.ecommerce.models.UserAddress;
import com.lekkss.ecommerce.repositories.UserAddressRepository;
import com.lekkss.ecommerce.repositories.UserRepository;
import com.lekkss.ecommerce.services.UserAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAddressImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserAddressDto addAddress(UserAddressDto userAddressDto) {
        UserAddress address = modelMapper.map(userAddressDto, UserAddress.class);
        UserAddress savedAddress = userAddressRepository.save(address);
        return modelMapper.map(savedAddress, UserAddressDto.class);
    }

    @Override
    public List<UserAddressDto> getAddressByUserId(Integer userId) {
        List<UserAddress> addresses = userAddressRepository.findByUserId(userId);

        return addresses.stream()
                .map(address -> modelMapper
                        .map(address, UserAddressDto.class))
                .collect(Collectors
                        .toList());

    //        List<UserAddressDto> addressDtos = new ArrayList<>();
    //        for (UserAddress address : addresses) {
    //            addressDtos.add(modelMapper.map(address, UserAddressDto.class));
    //        }
    //        return addressDtos;
    }

    @Override
    public List<UserAddressDto> getAllAddresses() {
        List<UserAddress> addresses = userAddressRepository.findAll();
        return addresses.stream()
                .map(address -> modelMapper
                        .map(address, UserAddressDto.class))
                .collect(Collectors
                        .toList());
    }

}
