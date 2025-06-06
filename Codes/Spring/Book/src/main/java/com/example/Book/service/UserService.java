package com.example.Book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Book.dto.UserRequestDto;
import com.example.Book.entity.User;
import com.example.Book.repository.UserRepository;

@Service
public class UserService {
@Autowired 
private PasswordEncoder passwordencoder;
@Autowired 
private UserRepository repository;
	public void create(UserRequestDto dto) {
 User user = new User();
 user.setId(null);
 user.setName(dto.getName());
 user.setSurname(dto.getSurname());
 user.setGmail(dto.getGmail());
 user.setUsername(dto.getUsername());
 String encode = passwordencoder.encode(dto.getPassword());
 user.setPassword(encode);
 repository.save(user);
 
		
	}
	

}
