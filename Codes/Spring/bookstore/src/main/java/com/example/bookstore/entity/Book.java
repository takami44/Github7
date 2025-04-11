package com.example.bookstore.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "books")
@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor
public class Book {
 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
private String title ;
private String author ;
private LocalDate year;

}
