package com.example.bookstore.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private List<Student> students = new ArrayList<>();

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}

class Student {
    private String name;
    private int age;

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
