package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}