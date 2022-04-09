package com.encrypt.password.encrypt.controller;

import java.util.List;
import java.util.Optional;

import com.encrypt.password.encrypt.model.UserModel;
import com.encrypt.password.encrypt.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository repository;
    private PasswordEncoder encoder;

    public UserController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserModel>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<UserModel> save(@RequestBody UserModel user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.ok(repository.save(user));
    }

    @GetMapping("/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestParam String login, @RequestParam String password) {

        Optional<UserModel> optUser = repository.findByLogin(login);

        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        UserModel user = optUser.get();
        Boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
    
}
