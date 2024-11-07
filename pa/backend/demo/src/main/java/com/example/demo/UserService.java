package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    // 注册方法
    public User register(User user) {
        // 检查用户名是否已存在
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                throw new RuntimeException("用户名已存在");
            }
        }
        users.add(user);
        return user;
    }

    // 登录方法
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new RuntimeException("用户名或密码错误");
    }
}