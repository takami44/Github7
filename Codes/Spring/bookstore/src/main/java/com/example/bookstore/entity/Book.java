package com.example.bookstore.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title boş ola bilməz")
    @Size(min = 2, max = 100, message = "Title 2-100 simvol arasında olmalıdır")
    private String title;

    @NotBlank(message = "Author boş ola bilməz")
    @Size(min = 2, max = 100, message = "Author 2-100 simvol arasında olmalıdır")
    private String author;

    @NotNull(message = "Year boş ola bilməz")
    @PastOrPresent(message = "Year keçmiş və ya indiki tarix olmalıdır")
    private LocalDate year;
