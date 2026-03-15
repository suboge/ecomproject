package com.popo.springecom.service;

import com.popo.springecom.model.User;
import com.popo.springecom.model.dto.RegisterRequest;
import com.popo.springecom.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("這個帳號已經被註冊過囉！");
        }

        User newUser = new User();
        newUser.setUsername(request.username());

        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setRole("USER");

        userRepository.save(newUser);

        return "註冊成功！";
    }
}