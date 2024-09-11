package com.lekkss.ecommerce.controllers;

import com.lekkss.ecommerce.dto.UserAddressDto;
import com.lekkss.ecommerce.models.UserAddress;
import com.lekkss.ecommerce.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/address")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @PostMapping
    public ResponseEntity<UserAddressDto> createAddress(@RequestBody UserAddressDto userAddress) {
        UserAddressDto address =  userAddressService.addAddress(userAddress);
        return  new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<UserAddressDto>> getAllAddresses(@PathVariable("id") Integer id) {
        List<UserAddressDto> addresses = userAddressService.getAddressByUserId(id);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserAddressDto>> getAllAddresses() {
        List<UserAddressDto> addresses = userAddressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
}
