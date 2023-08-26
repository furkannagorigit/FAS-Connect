package com.fas.connect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fas.connect.entities.Faculty;
import com.fas.connect.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	Optional<Student> findByRollNoAndUserEmail(String rollNo , String email);

}
