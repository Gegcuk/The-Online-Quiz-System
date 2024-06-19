package com.gegcuk.online_quizzes.service;

import com.gegcuk.online_quizzes.model.User;

public interface UserService {
    User register(User user);
    User updateUser(User user);
    void deleteUser(Integer id);
    User findByUsername(String username);
    User findByEmail(String email);
}
