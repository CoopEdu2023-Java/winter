package cn.msa.museum.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.msa.museum.exception.BusinessException;
import cn.msa.museum.exception.ExceptionEnum;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/auth")
    public String auth(Authentication auth) {
        return auth.getName();
    }

    @GetMapping("/error")
    public void error() {
        throw new BusinessException(ExceptionEnum.USER_DOES_NOT_EXIST);
    }
}
