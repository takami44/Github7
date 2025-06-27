package com.example.Book.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Book.dto.UserRequestDto;
import com.example.Book.entity.User;
import com.example.Book.repository.UserRepository;
import com.example.Book.util.JwtUtil;

@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordencoder;
	@Autowired
	private UserRepository repository;
@Autowired 
private JwtUtil jwtUtil;
	public void create(UserRequestDto dto) {
		Optional<User> byUsername = repository.findByUsername(dto.getUsername());
		if (byUsername.isPresent()) {
			throw new RuntimeException("Username is exist");
		}    
 
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

	public String login(UserRequestDto dto) {
		Optional<User> byUsername =repository.findByUsername(dto.getUsername());
			if (!byUsername.isPresent() || !passwordencoder.matches(dto.getPassword(),byUsername.get().getPassword())){
				throw new RuntimeException("Username OR PASSWORD INCORRET");			
 
		}
			return jwtUtil.generateToken(byUsername.get().getUsername());
}

}
