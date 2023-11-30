package com.example.splitwise.controllers;

import com.example.splitwise.Services.UserService;
import com.example.splitwise.dtos.UserDto;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;
    public User createUser(UserDto request) {

        return userService.createUser(request.toUser());
    }

}
