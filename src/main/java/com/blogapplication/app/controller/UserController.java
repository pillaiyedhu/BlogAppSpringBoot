package com.blogapplication.app.controller;


import com.blogapplication.app.payload.UserDto;
import com.blogapplication.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = userService.getAllUser();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long id){
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id){
        UserDto deletedUser = userService.deleteUser(id);
        return ResponseEntity.ok(deletedUser);
    }


}
