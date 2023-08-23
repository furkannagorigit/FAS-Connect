package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fas.connect.entities.Faculty;
import java.lang.String;
import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	 Optional<Faculty> findByFacultyId(String id);

	Optional<Faculty> findByFacultyIdAndUserEmail(String facultyId, String email);
}