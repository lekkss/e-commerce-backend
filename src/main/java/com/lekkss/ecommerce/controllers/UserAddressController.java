package com.lekkss.ecommerce.controllers;

import com.lekkss.ecommerce.dto.UserAddressDto;
import com.lekkss.ecommerce.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
