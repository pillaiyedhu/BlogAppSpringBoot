package com.blogapplication.app.service;

import com.blogapplication.app.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUser();
    UserDto getUserById(Long id);
    UserDto updateUser(Long id, UserDto userDto);
    UserDto deleteUser(Long id);

}
