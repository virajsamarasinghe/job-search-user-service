package com.jobsearch.user_service.controller;


import com.jobsearch.user_service.dto.RoleDto;
import com.jobsearch.user_service.entity.Role;
import com.jobsearch.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PostMapping("/create-role")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {

        Role role = new Role(

                roleDto.getRoleName(),
                roleDto.getRoleDescription()
        );

        roleService.createRole(role);


        RoleDto savedRoleDto = new RoleDto(

                role.getRoleName(),
                role.getRoleDescription()
        );
        return ResponseEntity.ok(savedRoleDto);

    }

}
