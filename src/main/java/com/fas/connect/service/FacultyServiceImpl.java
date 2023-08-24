package com.fas.connect.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.entities.Faculty;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.FacultyRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
@Service
@Transactional

public class FacultyServiceImpl implements FacultyService{

	@Autowired
	FacultyRepository facultyRepo;

	@Autowired
	ImageHandlingService imageService;


	@Autowired
	ModelMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public FacultyDTO getFacultyDetails(Long facultyId) {
		Faculty faculty = facultyRepo.findById(facultyId).
				orElseThrow();
		return mapper.map(faculty,FacultyDTO.class);
	}


	//Service to edit faculty details
	@Override
	public FacultyDTO updateFaculty(FacultyDTO facultyDTO) {
		Faculty faculty = facultyRepo
				.findByFacultyIdAndUserEmail(facultyDTO.getFacultyId(), facultyDTO.getUser().getEmail())
				.orElseThrow(()-> new ResourceNotFoundException("Faculty not found"));
		mapper.map(facultyDTO, faculty);
		faculty.getUser().setId(faculty.getUserId());
		System.out.println(facultyDTO.getUser().getPassword().length());
		faculty.getUser().setPassword(passwordEncoder.encode(facultyDTO.getUser().getPassword()));
		return mapper.map(facultyRepo.save(faculty), FacultyDTO.class);
	}





}
