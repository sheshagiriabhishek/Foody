package com.abhishek.userservice.controller;

import com.abhishek.userservice.config.UserServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {

    private final UserServiceConfig userServiceConfig;

    @Autowired
    public UserServiceController(UserServiceConfig userServiceConfig){
        this.userServiceConfig = userServiceConfig;

    }

    @GetMapping("/config")
    public String getConfig(){
        return "Value of show SQL property:"+userServiceConfig.getShowSQL();
    }

}
