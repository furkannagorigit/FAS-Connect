package com.fas.connect.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.dto.MarksDTO;
import com.fas.connect.dto.StudentDTO;
import com.fas.connect.dto.UserDTO;
import com.fas.connect.entities.User;

public interface UserService {
	//Get list of users
	List<User> getAllUsers();

	//	//Edit User
	//	User editUser(Long id, UserDTO userDTO);

	//Add Faculty
	FacultyDTO addFaculty(FacultyDTO facultyDTO);

	//Edit faculty
	FacultyDTO editFaculty(FacultyDTO userDTO);
//	FacultyDTO editFaculty(String facultyID, String email);

	//Delete Faculty
	void deleteFaculty(Long id);

	//Edit Student
	StudentDTO editStudent(StudentDTO studentDTO);

	//	//Delete Student
	//	void deleteStudent(Long id);

	//	//Delete Student from Course
	//	void deleteStudentFromCourse(Long courseId, Long userId);

	//Delete Student from Course
	void deleteStudent(Long userId);

	//Add Student to Course
	ResponseEntity<?> AddStudentsToCourse(List<StudentDTO> students,long courseId);
	
	//Get Student's Module wise Marks
	List<MarksDTO> getMarks(Long id);
	
	//Add Student's Module wise Marks
	MarksDTO addMarks(MarksDTO marksDTO);
}