package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repositry.BookRepositry;


@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")
public class BookController {
	@Autowired
	private BookRepositry bookRepositry;
	

    @GetMapping("/getall")
    public String getBooks(Model model) {
        model.addAttribute("books", List.of("Kitab 1", "Kitab 2", "Kitab 3"));
        return "books";
    }
    @PostMapping (path = "/add" )
    public void addBook(@RequestBody Book book ) {
    	bookRepositry.save(book);
    }
}
