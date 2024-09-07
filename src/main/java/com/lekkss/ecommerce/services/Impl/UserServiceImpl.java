package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.UserDto;
import com.lekkss.ecommerce.models.User;
import com.lekkss.ecommerce.repositories.UserRepository;
import com.lekkss.ecommerce.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(UserDto userDto) {
        //convert userDto to user
        User user = modelMapper.map(userDto, User.class);
//        //encode password
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //save user
        User savedUser = userRepository.save(user);

        //map user to userDto
        return modelMapper.map(savedUser, UserDto.class);
    }
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
