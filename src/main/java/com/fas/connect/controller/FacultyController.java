package com.fas.connect.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.service.FacultyService;
import com.fas.connect.service.ImageHandlingService;

@RestController
@RequestMapping("/faculty/profile")
@Validated
public class FacultyController {
	@Autowired
	private ImageHandlingService imageService;

	@Autowired
	private FacultyService facultyService;

	//GET mapping to get single faculty
		@GetMapping("/{facultyId}")
		public ResponseEntity<?> getFaculty(@PathVariable Long facultyId) {
			return ResponseEntity.ok(facultyService.getFacultyDetails(facultyId));
		}
	
	
	//PUT mapping to update faculty details
		@PutMapping
		public ResponseEntity<?> updateFaculty(@RequestBody FacultyDTO facultyDTO) {
		        facultyService.updateFaculty(facultyDTO);
				return ResponseEntity.status(HttpStatus.OK).body("Faculty updated successfully!");

		}
	
		//Post mapping to upload profile image
		@PostMapping(value = "/image/{facultyId}", consumes = "multipart/form-data")
		public ResponseEntity<?> uploadImage(@PathVariable Long facultyId, @RequestParam MultipartFile imageFile)
				 {
			System.out.println("in upload img " + facultyId);
			return ResponseEntity.status(HttpStatus.CREATED).body(imageService.uploadImage(facultyId, imageFile));
		}


}
