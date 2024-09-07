package com.lekkss.ecommerce.services;

import com.lekkss.ecommerce.dto.UserDto;
import com.lekkss.ecommerce.models.User;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    User getUserByUsername(String username);
}
