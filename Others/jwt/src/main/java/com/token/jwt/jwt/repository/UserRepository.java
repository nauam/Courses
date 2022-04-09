package com.token.jwt.jwt.repository;

import java.util.Optional;

import com.token.jwt.jwt.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    public Optional<UserModel> findByLogin(String login);
    
}
