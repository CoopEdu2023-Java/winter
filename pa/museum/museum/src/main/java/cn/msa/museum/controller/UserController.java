package cn.msa.museum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.msa.museum.dto.LoginDto;
import cn.msa.museum.dto.RegisterDto;
import cn.msa.museum.dto.ResponseDto;
import cn.msa.museum.exception.BusinessException;
import cn.msa.museum.exception.ExceptionEnum;
import cn.msa.museum.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseDto<String> login(@RequestBody LoginDto loginDto) {
        if (loginDto.getUsername() == null || loginDto.getPassword() == null) {
            throw new BusinessException(ExceptionEnum.MISSING_PARAMETERS);
        }

        String token = userService.login(loginDto);
        return new ResponseDto<>(token);
    }

    @PostMapping("/register")
    public ResponseDto<Void> register(@RequestBody RegisterDto registerDto) {
        if (registerDto.getUsername() == null || registerDto.getPassword() == null) {
            throw new BusinessException(ExceptionEnum.MISSING_PARAMETERS);
        }
        userService.register(registerDto);
        return new ResponseDto<>();
    }

}
