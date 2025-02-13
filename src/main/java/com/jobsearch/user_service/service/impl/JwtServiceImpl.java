package com.jobsearch.user_service.service.impl;

import com.jobsearch.user_service.dto.LoginRequest;
import com.jobsearch.user_service.dto.LoginResponse;
import com.jobsearch.user_service.entity.Role;
import com.jobsearch.user_service.entity.User;
import com.jobsearch.user_service.repository.UserRepository;
import com.jobsearch.user_service.service.JwtService;
import com.jobsearch.user_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class JwtServiceImpl implements JwtService , UserDetailsService {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();

        if(user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//
//        for(Role role : user.getRole()) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//        }

        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });

        return authorities;

    }

    @Override
    public LoginResponse createJwtToken(LoginRequest loginRequest)  throws Exception {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        authenticate(username, password);

        UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        User user = userRepository.findById(username).get();

        LoginResponse loginResponse = new LoginResponse(
                user,
                newGeneratedToken
        );

        return loginResponse;

    }

    private void authenticate(String username, String password) throws Exception {
        // Implement authentication logic here

        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        }catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
