package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fas.connect.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}