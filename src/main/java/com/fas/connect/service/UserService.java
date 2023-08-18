package com.fas.connect.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fas.connect.dto.CourseDTO;
import com.fas.connect.dto.CourseStudentsDTO;
import com.fas.connect.dto.StudentDTO;

public interface UserService {
	List<CourseDTO> getAllCourses();
	List<CourseDTO> getAllUsers();
	CourseDTO getCourseDetails(Long courseId);
	CourseDTO addNewCourse(CourseDTO course);
	CourseStudentsDTO getCourseAndStudentsDetails(Long courseId);
	ResponseEntity<?> AddStudentsToCourse(List<StudentDTO> students,long courseId);
	
}
