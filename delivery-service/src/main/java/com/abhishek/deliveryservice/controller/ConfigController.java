package com.abhishek.deliveryservice.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
     @Value("${spring.datasource.url}")
     private String dataSourceUrl;

     @Value("${spring.datasource.username}")
     private String dataSourceUsername;

     @Value("${spring.datasource.password}")
     private String dataSourcePassword;

    @Value("${name}")
    private String name;

     @GetMapping("/config")
     public String getConfig() {
         return "Name:"+name+" URL: " + dataSourceUrl + ", Username: " + dataSourceUsername + ", Password: " + dataSourcePassword;
     }
}


