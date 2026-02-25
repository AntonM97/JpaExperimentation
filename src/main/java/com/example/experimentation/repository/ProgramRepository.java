package com.example.experimentation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.experimentation.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer> {

}
