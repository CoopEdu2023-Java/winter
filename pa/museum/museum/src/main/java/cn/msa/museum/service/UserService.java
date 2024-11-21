package cn.msa.museum.service;

import cn.msa.museum.dto.LoginDto;
import cn.msa.museum.dto.RegisterDto;

public interface UserService {

    public String login(LoginDto loginDto);

    public void register(RegisterDto registerDto);
}
