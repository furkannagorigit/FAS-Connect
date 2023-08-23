package com.fas.connect.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.dto.MarksDTO;
import com.fas.connect.dto.StudentDTO;
import com.fas.connect.dto.UserDTO;

public interface UserService {
	List<UserDTO> getAllUsers();
	ResponseEntity<?> addStudents(List<StudentDTO> students,long courseId);
	public FacultyDTO addFaculty(FacultyDTO facultyDTO);
	void deleteStudent(Long userId);
	void deleteFaculty(Long id);
	List<MarksDTO> getMarks(Long id);
	MarksDTO addMarks(MarksDTO marksDTO);
	public UserDetails loadUserByUsername(String username);

}
