package com.abhishek.userservice.service;

import com.abhishek.userservice.model.User;
import com.abhishek.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class JwtUserDetailsService extends MyUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new MyUserDetails(user);
    }
}
