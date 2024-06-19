package com.gegcuk.online_quizzes.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gegcuk.online_quizzes.model.User;
import com.gegcuk.online_quizzes.service.UserService;

@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
            model.addAttribute("user", user);
        }
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(User user, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User currentUser = userService.findByUsername(userDetails.getUsername()).orElseThrow();

            // Update user details
            currentUser.setEmail(user.getEmail());
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                currentUser.setPassword(user.getPassword());
            }

            userService.saveUser(currentUser);
            model.addAttribute("user", currentUser);
            model.addAttribute("message", "Profile updated successfully");
        }
        return "profile";
    }
}
