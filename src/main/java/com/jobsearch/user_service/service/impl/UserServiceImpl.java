package com.jobsearch.user_service.service.impl;

import com.jobsearch.user_service.entity.Role;
import com.jobsearch.user_service.entity.User;
import com.jobsearch.user_service.repository.RoleRepository;
import com.jobsearch.user_service.repository.UserRepository;
import com.jobsearch.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User saveUser(User user) {

        return userRepository.save(user);

    }

    public void initRoleAndUser() {
        Role adminRole = new Role();

        if (!roleRepository.existsById("Admin")) {

            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin Role");
            roleRepository.save(adminRole);

        }
        Role userRole = new Role();
        if (!roleRepository.existsById("User")) {

            userRole.setRoleName("User");
            userRole.setRoleDescription("User Role");
            roleRepository.save(userRole);

        }
        if (!userRepository.existsById("admin123")) {
            User adminUser = new User();
            adminUser.setUsername("admin123");
            adminUser.setPassword(getEncodedPassword("admin"));
            adminUser.setFirstName("Admin");
            adminUser.setLastName("Admin");
            adminUser.setEmail("Admin@gmail.com");
            adminUser.setPhoneNumber("1234567890");
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);

            adminUser.setRole(adminRoles);
            userRepository.save(adminUser);

        }

        if (!userRepository.existsById("user123")) {
            User user = new User();
            user.setUsername("user123");
            user.setPassword(getEncodedPassword("user"));
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setEmail("Admin@gmail.com");
            user.setPhoneNumber("1234567890");
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);

            user.setRole(userRoles);
            userRepository.save(user);

        }

    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
