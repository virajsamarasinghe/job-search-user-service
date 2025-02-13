package com.jobsearch.user_service.repository;

import com.jobsearch.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {



}
