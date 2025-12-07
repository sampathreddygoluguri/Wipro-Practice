package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(String username, String rawPassword, String roleStr) {

        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }

        User u = new User();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(rawPassword));

        // Convert input role -> internal system role
        String normalized = (roleStr == null ? "user" : roleStr.trim().toLowerCase());

        switch (normalized) {
            case "teamlead":
            case "tl":
                u.setRole("ROLE_TL");   
                break;

            case "user":
            default:
                u.setRole("ROLE_SD");   
                break;
        }

        return userRepository.save(u);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}