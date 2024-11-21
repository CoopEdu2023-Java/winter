package cn.msa.museum.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cn.msa.museum.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    public boolean existsByUsername(String username);

    public Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    public Optional<UserEntity> findByUsername(String username);

}
