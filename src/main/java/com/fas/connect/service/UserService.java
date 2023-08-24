package com.fas.connect.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.dto.MarksDTO;
import com.fas.connect.dto.SigninRequest;
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
	UserDTO signIn(SigninRequest request);


}
