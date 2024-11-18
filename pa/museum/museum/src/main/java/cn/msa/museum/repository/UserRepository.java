package cn.msa.museum.repository;

import org.springframework.data.repository.CrudRepository;

import cn.msa.museum.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    public boolean existsByUsernameAndPassword(String username, String password);

    public UserEntity findByUsernameAndPassword(String username, String password);

}
