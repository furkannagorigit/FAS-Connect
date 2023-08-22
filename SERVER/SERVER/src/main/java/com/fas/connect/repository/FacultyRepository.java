package com.fas.connect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entities.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	//get faculty by facultyId and email
	Optional<Faculty> findByFacultyIdAndUserEmail(String facultyId, String email);
}
