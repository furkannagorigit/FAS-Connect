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
import com.fas.connect.dto.ModuleDTO;
import com.fas.connect.service.CourseService;


@RestController
@RequestMapping("/course")
@Validated
public class CourseController {
	@Autowired
	private CourseService courseService;

	
	// to get all courses
	@GetMapping("/allCourse")
	public ResponseEntity<?> getAllCourses() {
		List<CourseDTO> list = courseService.getAllCourses();
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(list);
		
	}
	@GetMapping("/{courseId}")
	public ResponseEntity<?> getCourse(@PathVariable Long courseId) {
		return ResponseEntity.ok(courseService.getCourseDetails(courseId));
		
	}
	// to add new course
	@PostMapping
	public ResponseEntity<?> addNewCourse(@RequestBody @Valid CourseDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addNewCourse(dto));
	}
	
	// to add new module
	@PostMapping("/addModule")
	public ResponseEntity<?> addNewModule(@RequestBody @Valid ModuleDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addNewModule(dto));
	}
	


}
