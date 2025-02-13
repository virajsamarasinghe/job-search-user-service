package com.jobsearch.user_service.controller;


import com.jobsearch.user_service.dto.LoginRequest;
import com.jobsearch.user_service.dto.LoginResponse;
import com.jobsearch.user_service.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {


    @Autowired
    private JwtService jwtService;


    @PostMapping("/authenticate")
    public LoginResponse authenticate(@RequestBody LoginRequest loginRequest) throws Exception {
        return jwtService.createJwtToken(loginRequest);
    }
}




