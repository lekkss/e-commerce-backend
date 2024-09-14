package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.UserAddressDto;
import com.lekkss.ecommerce.exceptions.RecordNotFoundException;
import com.lekkss.ecommerce.models.UserAddress;
import com.lekkss.ecommerce.repositories.UserAddressRepository;
import com.lekkss.ecommerce.services.UserAddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserAddressImpl implements UserAddressService {

    private UserAddressRepository userAddressRepository;


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

    @Override
    public UserAddressDto updateAddress(UserAddressDto userAddressDto, Integer id) {
        UserAddress address = userAddressRepository
                .findById(id).orElseThrow(() -> new RecordNotFoundException("UserAddress", "AddressID",id));
        address.setAddressLine1(userAddressDto.getAddressLine1());
        address.setAddressLine2(userAddressDto.getAddressLine2());
        address.setCity(userAddressDto.getCity());
        address.setCountry(userAddressDto.getCountry());
        address.setPostalCode(userAddressDto.getPostalCode());
        address.setPhone(userAddressDto.getPhone());
        address.setMobile(userAddressDto.getMobile());
        UserAddress savedAddress = userAddressRepository.save(address);
        return modelMapper.map(savedAddress, UserAddressDto.class);
    }

    @Override
    public void deleteAddress(Integer id) throws RecordNotFoundException {
        UserAddress address = userAddressRepository
                .findById(id).orElseThrow(() -> new RecordNotFoundException("UserAddress", "AddressID",id));
        userAddressRepository.delete(address);
    }

}
