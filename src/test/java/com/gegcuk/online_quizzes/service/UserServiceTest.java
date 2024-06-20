package com.gegcuk.online_quizzes.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.gegcuk.online_quizzes.model.User;
import com.gegcuk.online_quizzes.repository.UserRepository;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser_Success() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");

        when(userRepository.findByUsername("testuser")).thenReturn(null);
        when(userRepository.findByEmail("testuser@example.com")).thenReturn(null);
        when(userRepository.save(any(User.class))).thenReturn(user);

        userService.registerUser(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testRegisterUser_UsernameExists() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");

        when(userRepository.findByUsername("testuser")).thenReturn(new User());

        assertThrows(RuntimeException.class, () -> {
            userService.registerUser(user);
        });

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void testRegisterUser_EmailExists() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");

        when(userRepository.findByEmail("testuser@example.com")).thenReturn(new User());

        assertThrows(RuntimeException.class, () -> {
            userService.registerUser(user);
        });

        verify(userRepository, never()).save(any(User.class));
    }
}
