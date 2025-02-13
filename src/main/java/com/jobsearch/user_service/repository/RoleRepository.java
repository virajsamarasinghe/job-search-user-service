package com.jobsearch.user_service.repository;

import com.jobsearch.user_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, String> {



}
