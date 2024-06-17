package com.abhishek.userservice.controller;

import com.abhishek.userservice.config.UserServiceConfig;
import com.abhishek.userservice.model.User;
import com.abhishek.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserServiceController {

    private final UserServiceConfig userServiceConfig;

    @Autowired
    private UserService userService;

    @Autowired
    public UserServiceController(UserServiceConfig userServiceConfig){
        this.userServiceConfig = userServiceConfig;

    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/userInfo/{username}")
    public User getUserInfo( @PathVariable String username){
        return userService.findByUsername(username);
    }

    @GetMapping("/config")
    public String getConfig(){
        return "Value of show SQL property:"+userServiceConfig.getShowSQL();
    }



}
