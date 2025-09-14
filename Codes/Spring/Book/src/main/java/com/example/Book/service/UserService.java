package com.example.Book.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Book.dto.UserRequestDto;
import com.example.Book.entity.User;
import com.example.Book.repository.UserRepository;
import com.example.Book.util.JwtUtil;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    public void create(UserRequestDto dto) {
        Optional<User> existingUser = repository.findByUsername(dto.getUsername());
        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setGmail(dto.getGmail()); 
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        repository.save(user);
    }

    public String login(UserRequestDto dto) {
        Optional<User> userOpt = repository.findByUsername(dto.getUsername());
        if (userOpt.isEmpty() || !passwordEncoder.matches(dto.getPassword(), userOpt.get().getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }

        return jwtUtil.generateToken(userOpt.get().getUsername());
    }
}
