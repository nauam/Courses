package com.encrypt.password.encrypt.repository;

import java.util.Optional;

import com.encrypt.password.encrypt.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    public Optional<UserModel> findByLogin(String login);
    
}
