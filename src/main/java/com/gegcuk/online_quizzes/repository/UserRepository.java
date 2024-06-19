package com.gegcuk.online_quizzes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gegcuk.online_quizzes.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
