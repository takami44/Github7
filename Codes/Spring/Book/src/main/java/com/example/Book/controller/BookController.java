package com.example.Book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Book.dto.BookRequestdto;
import com.example.Book.dto.UserRequestDto;
import com.example.Book.service.BookService;
import com.example.Book.service.UserService;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")
                     
public class BookController {
@Autowired
private BookService bookservice;


@PostMapping(path = "/create")
public void userCreate(@RequestBody BookRequestdto dto) {
	
bookservice.register(dto);	
	
}
}
