package com.fas.connect.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fas.connect.repository.CourseRepository;
import com.fas.connect.repository.StudentRepository;
import com.fas.connect.repository.UserRepository;
import com.fas.connect.dto.CourseDTO;
import com.fas.connect.dto.CourseStudentsDTO;
import com.fas.connect.dto.StudentDTO;
import com.fas.connect.entities.Course;
import com.fas.connect.entities.Student;
import com.fas.connect.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModelMapper mapper;


	@Override
	public List<CourseDTO> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDTO getCourseDetails(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDTO addNewCourse(CourseDTO course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseStudentsDTO getCourseAndStudentsDetails(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> AddStudentsToCourse(List<StudentDTO> students, long courseId) {

		Course course = courseRepo.findById(courseId).orElseThrow();
		for (StudentDTO studentDTO : students) {
			User user = userRepo.save(studentDTO.getUser());
			Student student = new Student(studentDTO.getRollNo(), user);
			course.addStudent(student);

		}
		String successMessage = "Students added successfully to the course.";
		return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);	}

}
