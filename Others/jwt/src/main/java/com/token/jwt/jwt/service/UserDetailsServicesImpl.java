package com.token.jwt.jwt.service;

import java.util.Optional;

import com.token.jwt.jwt.data.UserDetailsData;
import com.token.jwt.jwt.model.UserModel;
import com.token.jwt.jwt.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServicesImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServicesImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = repository.findByLogin(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new UserDetailsData(user);
    }
    
}
