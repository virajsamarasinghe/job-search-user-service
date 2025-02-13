package com.jobsearch.user_service.service;

import com.jobsearch.user_service.dto.RoleDto;
import com.jobsearch.user_service.entity.Role;

public interface RoleService {
    Role createRole(Role role);
}
