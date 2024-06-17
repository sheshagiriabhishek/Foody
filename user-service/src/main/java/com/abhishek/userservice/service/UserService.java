package com.abhishek.userservice.service;

import com.abhishek.userservice.model.User;
import com.abhishek.userservice.repository.UserRepository;

public interface UserService {
    User registerUser(User user);
    User findByUsername(String username);
}
