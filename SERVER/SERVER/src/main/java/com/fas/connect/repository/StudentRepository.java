package com.fas.connect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	//Get student by rollNo and email
	Optional<Student> findByRollNoAndUserEmail(String rollNo, String email);	
}
