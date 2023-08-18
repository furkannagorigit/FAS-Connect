package com.fas.connect.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas.connect.dto.CourseDTO;
import com.fas.connect.dto.StudentDTO;
import com.fas.connect.entities.Student;
import com.fas.connect.service.CourseService;
import com.fas.connect.service.UserService;


@RestController
@RequestMapping("/users")
@Validated
public class UserController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/addStudents/{courseId}")
	public ResponseEntity<?> AddUsers(@RequestBody @Valid List<StudentDTO> studentDTO,@PathVariable Long courseId) {
		 return userService.AddStudentsToCourse(studentDTO, courseId);
	}


}
