package com.example.Book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Book.dto.UserRequestDto;
import com.example.Book.service.UserService;

@RestController
@RequestMapping(path = "/auth")
@CrossOrigin(origins = "*")

public class AuthController {
	@Autowired
	private UserService userService;
	

	@PostMapping(path = "/add")
	public void userCreate(@RequestBody UserRequestDto dto) {
		userService.create(dto);
	}

}
