package com.abhishek.userservice.controller;

import com.abhishek.userservice.model.JwtRequest;
import com.abhishek.userservice.model.JwtResponse;
import com.abhishek.userservice.service.MyUserDetailsService;
import com.abhishek.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserAuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/authenticate")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

