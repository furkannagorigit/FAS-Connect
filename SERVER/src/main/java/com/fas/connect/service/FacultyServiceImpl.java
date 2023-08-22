package com.fas.connect.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.entities.Faculty;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.FacultyRepository;
@Service
@Transactional

public class FacultyServiceImpl implements FacultyService{

	@Autowired
	FacultyRepository facultyRepo;
	
	@Autowired
	ModelMapper mapper;
	
	
	@Override
	public FacultyDTO getFacultyDetails(Long facultyId) {
		Faculty faculty = facultyRepo.findById(facultyId).
				orElseThrow();
		return mapper.map(faculty,FacultyDTO.class);
	}

	//To update faculty
	@Override
	public FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO) {
		Faculty faculty = facultyRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculty not found"));
		mapper.map(facultyDTO, faculty);		
		return mapper.map(facultyRepo.save(faculty), FacultyDTO.class);
	}


}
