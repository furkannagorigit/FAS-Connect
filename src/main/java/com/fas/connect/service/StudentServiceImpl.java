package com.fas.connect.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas.connect.dto.StudentDTO;
import com.fas.connect.entities.Student;
import com.fas.connect.repository.StudentRepository;
@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public StudentDTO getStudentDetails(Long studentId) {
		Student student = studentRepo.findById(studentId).
				orElseThrow();
		return mapper.map(student,StudentDTO.class);
		}

	//To update student
	@Override
	public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
		Student student = studentRepo.findById(id)
				.orElseThrow();
		mapper.map(studentDTO, student);
		return mapper.map(studentRepo.save(student), StudentDTO.class);
	}

}
