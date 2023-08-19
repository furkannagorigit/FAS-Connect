package com.fas.connect.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.dto.StudentDTO;
import com.fas.connect.dto.UserDTO;
import com.fas.connect.entity.User;
import com.fas.connect.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	//Dependancy Injecion

	//Service DI
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
	}

	//POST mapping to add a faculty record
	@PostMapping("/addFaculty")
	public ResponseEntity<?> addFaculty(@RequestBody FacultyDTO facultyDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addFaculty(facultyDTO));
	}

	//PUT mapping to edit faculty details
	@PutMapping("/editFaculty/{userId}")
	public ResponseEntity<?> editFaculty(@PathVariable Long userId, @RequestBody FacultyDTO facultyDTO){
		userService.editFaculty(userId, facultyDTO);
		return ResponseEntity.status(HttpStatus.OK).body("Faculty edited successfully!");
	}
	
	//PUT mapping to edit student details
	@PutMapping("/editStudent/{userId}")
	public ResponseEntity<?> editStudent(@PathVariable Long userId, @RequestBody StudentDTO studentDTO){
		userService.editStudent(userId, studentDTO);
		return ResponseEntity.status(HttpStatus.OK).body("Faculty edited successfully!");
	}

	//DELETE mapping to delete a faculty record
	@DeleteMapping("deleteFaculty/{userId}")
	public ResponseEntity<?> deleteFaculty(@PathVariable Long userId){
		userService.deleteFaculty(userId);
		return ResponseEntity.status(HttpStatus.OK).body("Faculty deleted successfully!");
	}

//	//DELETE mapping to delete a student
//	@DeleteMapping("deleteStudent/{userId}")
//	public ResponseEntity<?> deleteStudent(@PathVariable Long userId){
//		userService.deleteStudent(userId);
//		return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully!");
//	}
	
	//DELETE mapping to delete a student record from course
	@DeleteMapping("deleteStudent/{userId}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long userId){
		userService.deleteStudent(userId);
		return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully!");
	}
	
	//POST mapping to adda a student record to course
	@PostMapping("/addStudents/{courseId}")
	public ResponseEntity<?> AddUsers(@RequestBody @Valid List<StudentDTO> studentDTO,@PathVariable Long courseId) {
		 return userService.AddStudentsToCourse(studentDTO, courseId);
	}
}