package cn.msa.museum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.msa.museum.entity.UserEntity;
import cn.msa.museum.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody UserEntity user) {
        userService.login(user);
    }

    @PostMapping("/register")
    public void register(@RequestBody UserEntity user) {
        userService.register(user);
    }

}
