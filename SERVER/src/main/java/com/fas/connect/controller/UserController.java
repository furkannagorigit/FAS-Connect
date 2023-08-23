package com.fas.connect.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.dto.MarksDTO;
import com.fas.connect.dto.StudentDTO;
import com.fas.connect.entities.JwtResponse;
import com.fas.connect.entities.LoginForm;
import com.fas.connect.security.JwtHelper;
import com.fas.connect.service.UserService;


@RestController
@RequestMapping("/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	  @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtHelper jwtHelper;

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) throws UsernameNotFoundException {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword())
	            );
	        } catch (AuthenticationException e) {
	            return ResponseEntity.status(401).build(); // Unauthorized
	        }

	        final UserDetails userDetails = userService.loadUserByUsername(loginForm.getEmail());
	        final String token = jwtHelper.generateToken(userDetails);

	        return ResponseEntity.ok(new JwtResponse(token));
	    }

	// To get all users
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
	}

	@PostMapping("/addStudents/{courseId}")
	public ResponseEntity<?> addStudents(@RequestBody @Valid List<StudentDTO> studentDTO,@PathVariable Long courseId) {
		return userService.addStudents(studentDTO, courseId);
	}

	//POST mapping to add a faculty record
	@PostMapping("/addFaculty")
	public ResponseEntity<?> addFaculty(@RequestBody @Valid FacultyDTO facultyDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addFaculty(facultyDTO));
	}	
		
	//DELETE mapping to delete a faculty record
	@DeleteMapping("deleteFaculty/{userId}")
	public ResponseEntity<?> deleteFaculty(@PathVariable Long userId){
		userService.deleteFaculty(userId);
		return ResponseEntity.status(HttpStatus.OK).body("Faculty deleted successfully!");
	}

	//DELETE mapping to delete a student record from course
	@DeleteMapping("deleteStudent/{userId}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long userId){
		userService.deleteStudent(userId);
		return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully!");
	}
	
	//PostMapping to add a student's marks
		@PostMapping("/marks/addMarks")
		public ResponseEntity<?> addMarks(@RequestBody MarksDTO marksDTO){
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addMarks(marksDTO));
		}
		
		//GET mapping to get a list of marks
		@GetMapping("/marks/getMarks/{userId}")
		public ResponseEntity<?> getMarks(@PathVariable Long userId){
			return ResponseEntity.status(HttpStatus.OK).body(userService.getMarks(userId));
		}

}
