package com.fas.connect.service;

import com.fas.connect.dto.StudentDTO;

public interface StudentService {
	StudentDTO getStudentDetails(Long studentId);
	StudentDTO editStudent(StudentDTO studentDTO);
	
}
