package com.example.bookstore.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.entity.Book;

public interface BookRepositry extends JpaRepository<Book,Integer >{
	

}
