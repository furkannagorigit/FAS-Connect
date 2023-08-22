package com.fas.connect.service;

import com.fas.connect.dto.StudentDTO;

public interface StudentService {
	StudentDTO getStudentDetails(Long studentId);
	StudentDTO updateStudent(Long id, StudentDTO studentDTO);
	
}
