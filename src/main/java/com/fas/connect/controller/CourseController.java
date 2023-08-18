package com.fas.connect.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas.connect.dto.CourseDTO;
import com.fas.connect.service.CourseService;


@RestController
@RequestMapping("/course")
@Validated
public class CourseController {
	@Autowired
	private CourseService courseService;

	
	// to get 
	@GetMapping
	public ResponseEntity<?> getAllCourses() {
		List<CourseDTO> list = courseService.getAllCourses();
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(list);
		
	}


}
