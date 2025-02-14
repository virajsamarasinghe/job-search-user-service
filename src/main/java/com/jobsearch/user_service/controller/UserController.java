package com.jobsearch.user_service.controller;

import com.jobsearch.user_service.entity.User;
import com.jobsearch.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.jobsearch.user_service.dto.UserDto;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    // Create a new user using UserDTO
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userdto) {
        // Hash the password before saving the user
        String hashedPassword = passwordEncoder.encode(userdto.getPassword());

        // Corrected constructor usage
        User user = new User(

                userdto.getUsername(),
                hashedPassword,
                userdto.getFirstName(),
                userdto.getLastName(),
                userdto.getEmail(),
                userdto.getPhoneNumber(),
                userdto.getRole()  // Role should be last
        );

        // Save the user
        userService.saveUser(user);

        // Return saved user as a UserDto
        UserDto savedUserDTO = new UserDto(
                user.getUsername(),
                null,  // Do not return password in response
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole()
        );
        return ResponseEntity.ok(savedUserDTO);

    }

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @GetMapping("/for-admin")
    @PreAuthorize("hasRole('Admin')")
    public String getAllUsers() {
        return "All users";
    }


    @GetMapping("/for-user")
    @PreAuthorize("hasAnyRole('User','Admin')")
    public String forUser(){
        return "User-role";
    }

}
