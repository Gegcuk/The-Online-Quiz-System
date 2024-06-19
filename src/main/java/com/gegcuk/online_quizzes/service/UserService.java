package com.gegcuk.online_quizzes.service;

import java.util.Optional;

import com.gegcuk.online_quizzes.model.User;

public interface  UserService {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
