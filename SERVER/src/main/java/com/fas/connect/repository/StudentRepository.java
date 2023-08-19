package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}