package cn.msa.museum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cn.msa.museum.dto.LoginDto;
import cn.msa.museum.dto.RegisterDto;
import cn.msa.museum.entity.UserEntity;
import cn.msa.museum.exception.BusinessException;
import cn.msa.museum.exception.ExceptionEnum;
import cn.msa.museum.repository.UserRepository;
import cn.msa.museum.service.JwtService;
import cn.msa.museum.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private JwtService jwtService;

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public String login(LoginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        UserEntity existUser = UserRepository.findByUsername(username)
                .orElseThrow(() -> new BusinessException(ExceptionEnum.USER_EXISTS));

        if (!bCryptPasswordEncoder.matches(password, existUser.getPassword())) {
            throw new BusinessException(ExceptionEnum.WRONG_PASSWORD);
        }

        return jwtService.setToken(existUser);
    }

    @Override
    public void register(RegisterDto registerDto) {
        String username = registerDto.getUsername();
        String password = bCryptPasswordEncoder.encode(registerDto.getPassword());

        if (UserRepository.existsByUsername(username)) {
            throw new BusinessException(ExceptionEnum.USER_EXISTS);
        }
        UserRepository.save(new UserEntity(username, password));
    }
}
