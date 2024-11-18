package cn.msa.museum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.msa.museum.entity.UserEntity;
import cn.msa.museum.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public boolean login(UserEntity user) {
        return UserRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public void register(UserEntity user) {
        UserRepository.save(user);
    }
}
