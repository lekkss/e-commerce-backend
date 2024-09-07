package com.lekkss.ecommerce.controllers;

import com.lekkss.ecommerce.dto.UserDto;
import com.lekkss.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto user) {
        UserDto registerUser = userService.registerUser(user);
        return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }

}
