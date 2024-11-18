package cn.msa.museum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.msa.museum.entity.UserEntity;
import cn.msa.museum.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private JwtService jwtService;

    public String login(UserEntity userEntity) {
        UserEntity user = UserRepository.findByUsernameAndPassword(userEntity.getUsername(), userEntity.getPassword());
        return jwtService.setToken(user);
    }

    public void register(UserEntity userEntity) {
        UserRepository.save(userEntity);
    }
}
