package com.jobsearch.user_service.service;

import com.jobsearch.user_service.dto.LoginRequest;
import com.jobsearch.user_service.dto.LoginResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {


    public  UserDetails loadUserByUsername(String username)  ;

    LoginResponse createJwtToken(LoginRequest loginRequest) throws Exception;
}
