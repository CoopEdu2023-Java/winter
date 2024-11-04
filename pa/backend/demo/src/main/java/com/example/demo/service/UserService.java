package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {

    User loginService(String username, String password);

    User registerService(User user);
}
