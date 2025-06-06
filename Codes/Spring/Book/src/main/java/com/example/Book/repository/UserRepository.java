package com.example.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Book.entity.User;

public interface UserRepository extends JpaRepository< User,Integer > {

}
