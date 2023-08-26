package com.fas.connect.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fas.connect.dto.StudentDTO;
import com.fas.connect.service.ImageHandlingService;
import com.fas.connect.service.ImageHandlingServiceImpl;
import com.fas.connect.service.StudentService;

@RestController
@RequestMapping("/student/profile")
@Validated
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	ImageHandlingService imageService;
	
	//GET mapping to get single student
	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudent(@PathVariable Long studentId) {
		return ResponseEntity.ok(studentService.getStudentDetails(studentId));
	}

	//PUT mapping to edit student details
	@PutMapping("/editStudent")
	public ResponseEntity<?> editStudent(@RequestBody @Valid StudentDTO studentDTO){
		studentService.editStudent(studentDTO);
		return ResponseEntity.status(HttpStatus.OK).body("Student updated successfully!");
	}
	
	//Post mapping to upload profile image
	@PostMapping(value = "/image/{studentId}", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable Long studentId, @RequestParam MultipartFile imageFile)
			 {
		return ResponseEntity.status(HttpStatus.CREATED).body(imageService.uploadImage(studentId, imageFile));
	}



}
