package com.abhishek.userservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="spring.jpa")
public class UserServiceConfig {
    private String showSQL;

    // getters and setters
    public String getShowSQL() {
        return showSQL;
    }

    public void setShowSQL(String someProperty) {
        this.showSQL = showSQL;
    }
}
