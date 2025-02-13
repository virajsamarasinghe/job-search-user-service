package com.jobsearch.user_service.service.impl;


import com.jobsearch.user_service.dto.RoleDto;
import com.jobsearch.user_service.entity.Role;
import com.jobsearch.user_service.repository.RoleRepository;
import com.jobsearch.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;






    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role); // Save the role to the database
    }
}
