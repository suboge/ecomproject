package com.popo.springecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users") // 對應資料庫的 users 表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username; // 帳號 (實務上很多人會用 email 欄位來當帳號)

    @Column(nullable = false)
    private String password; // 密碼 (注意：存進資料庫的會是加密後的亂碼)

    private String role; // 權限角色，例如 "USER" 或 "ADMIN"
}