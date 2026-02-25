package com.example.experimentation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.experimentation.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
