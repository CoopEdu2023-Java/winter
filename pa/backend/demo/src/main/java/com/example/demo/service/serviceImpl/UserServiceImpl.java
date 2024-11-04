package com.example.demo.service.serviceImpl;

import com.example.demo.domain.User;
import com.example.demo.repository.UserDao;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User loginService(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registerService(User user) {
        if (userDao.findByUsername(user.getUsername()) != null) {
            return null;
        } else {
            User newUser = userDao.save(user);
            if (newUser != null) {
                newUser.setPassword("");
            }
            return newUser;
        }

    }
}
