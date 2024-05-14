package com.blogapplication.app.service.impl;

import com.blogapplication.app.entity.User;
import com.blogapplication.app.exception.ResourceNotFoundException;
import com.blogapplication.app.payload.UserDto;
import com.blogapplication.app.respository.UserRepository;
import com.blogapplication.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        return savedUserDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUsers = userRepository.findAll();
        List<UserDto> allUserDtos = new ArrayList<>();

        allUsers.stream().forEach(user -> {
            UserDto singleUserDto = modelMapper.map(user,UserDto.class);
            allUserDtos.add(singleUserDto);
        });

        return allUserDtos;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","userId",id));
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","userId",id));
        if(userDto.getUsername()!=null && userDto.getUsername()!=""){
            user.setUsername(userDto.getUsername());
        }
        if(userDto.getPassword()!=null && userDto.getPassword()!=""){
            user.setPassword(userDto.getPassword());
        }
        if(userDto.getEmail()!=null && userDto.getEmail()!=""){
            user.setEmail(userDto.getEmail());
        }
        userRepository.save(user);
        UserDto savedUserDto = modelMapper.map(user,UserDto.class);
        return savedUserDto;
    }

    @Override
    public UserDto deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","userId",id));
        userRepository.delete(user);
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }
}
