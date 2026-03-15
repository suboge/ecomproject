package com.popo.springecom.repo;

import com.popo.springecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // Spring Data JPA 的黑魔法：只要命名對了，它會自動幫你寫出 "SELECT * FROM users WHERE username = ?" 的 SQL
    Optional<User> findByUsername(String username);
}