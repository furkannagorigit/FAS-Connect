package com.fas.connect.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.service.FacultyService;

@RestController
@RequestMapping("/faculty/profile")
@Validated
public class FacultyController {
	@Autowired
	private FacultyService facultyService;

	//GET mapping to get single faculty
		@GetMapping("/{facultyId}")
		public ResponseEntity<?> getFaculty(@PathVariable Long facultyId) {
			return ResponseEntity.ok(facultyService.getFacultyDetails(facultyId));
		}
	
	
	//PUT mapping to update faculty details
		@PutMapping("/editFaculty/{userId}")
		public ResponseEntity<?> editFaculty(@PathVariable Long userId, @RequestBody @Valid FacultyDTO facultyDTO){
			facultyService.updateFaculty(userId, facultyDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Faculty updated successfully!");
		}
}
