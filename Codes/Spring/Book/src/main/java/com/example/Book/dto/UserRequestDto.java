package com.example.Book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
	private Integer id;
	private String name;
	private  String surname;
	private String username;
	private String password;
	private String gmail;
}
