package com.lekkss.ecommerce.controllers;

import com.lekkss.ecommerce.dto.UserAddressDto;
import com.lekkss.ecommerce.payloads.APIResponse;
import com.lekkss.ecommerce.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/address")
public class UserAddressController {

    private final UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @PostMapping
    public ResponseEntity<APIResponse<UserAddressDto>> createAddress(@RequestBody UserAddressDto userAddress) {
        APIResponse<UserAddressDto> apiResponse = new APIResponse<>();
        try {
            UserAddressDto address =  userAddressService.addAddress(userAddress);
            apiResponse.setData(address);
            apiResponse.setMessage("Address created successfully");
            return  new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<APIResponse<List<UserAddressDto>>> getAllAddresses(@PathVariable("id") Integer id) {
        APIResponse<List<UserAddressDto>> apiResponse = new APIResponse<>();
        try {
            List<UserAddressDto> addresses = userAddressService.getAddressByUserId(id);
            apiResponse.setData(addresses);
            apiResponse.setMessage("User address fetched successfully");
            return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<UserAddressDto>>> getAllAddresses() {
        APIResponse<List<UserAddressDto>> apiResponse = new APIResponse<>();
        try {
            List<UserAddressDto> addresses = userAddressService.getAllAddresses();
            apiResponse.setData(addresses);
            apiResponse.setMessage("Addresses fetched successfully");
            return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<APIResponse<UserAddressDto>> updateAddress(
            @PathVariable("id") Integer id,
            @RequestBody UserAddressDto address) {
        APIResponse<UserAddressDto> apiResponse = new APIResponse<>();
        try {
            UserAddressDto savedAddress = userAddressService.updateAddress(address, id);
            apiResponse.setData(savedAddress);
            apiResponse.setMessage("Address updated successfully");
            return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse<UserAddressDto>> deleteAddress(@PathVariable("id") Integer id) {
        APIResponse<UserAddressDto> apiResponse = new APIResponse<>();
        try {
            userAddressService.deleteAddress(id);
            apiResponse.setMessage("Address deleted successfully");
            return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            apiResponse.setMessage("error deleting address");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
