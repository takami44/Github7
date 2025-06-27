package com.example.Book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Book.dto.BookRequestdto;
import com.example.Book.entity.BookEntity;
import com.example.Book.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookrepository;

	public void register(BookRequestdto dto) {
BookEntity book = new BookEntity();
book.setId(null);
book.setName(dto.getName());
book.setPrice(dto.getPrice());
book.setAuthor(dto.getAuthor());
bookrepository.save(book);

		
	}

}
