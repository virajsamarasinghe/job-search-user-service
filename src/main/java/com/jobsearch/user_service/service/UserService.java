package com.jobsearch.user_service.service;

import com.jobsearch.user_service.entity.User;

import java.util.List;

public interface UserService {


    public User saveUser(User user);

    void initRoleAndUser();
}
