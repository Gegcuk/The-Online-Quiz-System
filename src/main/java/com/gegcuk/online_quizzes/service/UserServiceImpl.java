package com.gegcuk.online_quizzes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gegcuk.online_quizzes.model.User;
import com.gegcuk.online_quizzes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new IllegalArgumentException("Username already exitst.");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already exists");
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }    
}
