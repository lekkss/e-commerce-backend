package com.lekkss.ecommerce.services.Impl;

import com.lekkss.ecommerce.dto.UserDto;
import com.lekkss.ecommerce.models.User;
import com.lekkss.ecommerce.repositories.UserRepository;
import com.lekkss.ecommerce.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
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
