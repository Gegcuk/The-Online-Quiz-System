package com.gegcuk.online_quizzes.controller;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gegcuk.online_quizzes.config.TestSecurityConfig;
import com.gegcuk.online_quizzes.dto.UserRegistrationDto;
import com.gegcuk.online_quizzes.dto.UserUpdateDto;
import com.gegcuk.online_quizzes.model.User;
import com.gegcuk.online_quizzes.service.UserService;

@WebMvcTest(UserController.class)
@Import(TestSecurityConfig.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testRegisterUser() throws Exception {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setUsername("testuser");
        userRegistrationDto.setPassword("password");
        userRegistrationDto.setEmail("test@example.com");

        User user = new User();
        user.setUserId(1);
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setRole("USER");

        Mockito.when(userService.register(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userRegistrationDto)))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateUser() throws Exception {
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setUsername("updateduser");
        userUpdateDto.setEmail("updated@example.com");
        userUpdateDto.setPassword("updatedpassword");
        userUpdateDto.setRole("ADMIN");

        User user = new User();
        user.setUserId(1);
        user.setUsername("updateduser");
        user.setEmail("updated@example.com");
        user.setPassword("updatedpassword");
        user.setRole("ADMIN");

        Mockito.when(userService.updateUser(any(User.class))).thenReturn(user);

        mockMvc.perform(put("/api/users/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userUpdateDto)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteUser() throws Exception {
        Integer userId = 1;

        Mockito.doNothing().when(userService).deleteUser(userId);

        mockMvc.perform(delete("/api/users/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetUserByUsername() throws Exception {
        String username = "testuser";

        User user = new User();
        user.setUserId(1);
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setRole("USER");

        Mockito.when(userService.findByUsername(username)).thenReturn(user);

        mockMvc.perform(get("/api/users/{username}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
