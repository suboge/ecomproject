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
    private PasswordEncoder passwordEncoder; // 注入我們在 SecurityConfig 設定的加密器

    public String register(RegisterRequest request) {
        // 1. 檢查帳號是否已經被註冊過
        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("這個帳號已經被註冊過囉！");
        }

        // 2. 建立新的 User 實體
        User newUser = new User();
        newUser.setUsername(request.username());

        // 3. 核心步驟：將明文密碼加密後再存入 (BCrypt 加密)
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setRole("USER"); // 預設給予一般使用者權限

        // 4. 儲存進資料庫
        userRepository.save(newUser);

        return "註冊成功！";
    }
}