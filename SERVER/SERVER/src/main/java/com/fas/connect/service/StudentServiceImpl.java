package com.fas.connect.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas.connect.dto.StudentDTO;
import com.fas.connect.entities.Student;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.StudentRepository;
import com.fas.connect.repository.UserRepository;
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
				orElseThrow(()-> new ResourceNotFoundException("Student not found"));
		return mapper.map(student,StudentDTO.class);
		}

	//Service to edit student details
		@Override
		public StudentDTO editStudent(StudentDTO studentDTO) {		
			Student student = studentRepo
							.findByRollNoAndUserEmail(studentDTO.getRollNo(), studentDTO.getUser().getEmail())
							.orElseThrow(()-> new ResourceNotFoundException("Student not found"));
			mapper.map(studentDTO, student);
			student.getUser().setId(student.getUserId());
			return mapper.map(studentRepo.save(student), StudentDTO.class);
		}
}
