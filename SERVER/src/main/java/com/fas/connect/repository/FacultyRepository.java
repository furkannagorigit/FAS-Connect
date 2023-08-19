package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}