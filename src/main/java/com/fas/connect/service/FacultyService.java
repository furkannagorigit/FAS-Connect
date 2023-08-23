package com.fas.connect.service;


import com.fas.connect.dto.FacultyDTO;

public interface FacultyService {
	FacultyDTO getFacultyDetails(Long facultyId);
	FacultyDTO updateFaculty(FacultyDTO facultyDTO);
	
}
