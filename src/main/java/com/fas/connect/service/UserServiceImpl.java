package com.fas.connect.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fas.connect.repository.CourseRepository;
import com.fas.connect.repository.FacultyRepository;
import com.fas.connect.repository.ModuleRepository;
import com.fas.connect.repository.StudentModuleMarksRepository;
import com.fas.connect.repository.StudentRepository;
import com.fas.connect.repository.UserRepository;
import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.dto.MarksDTO;
import com.fas.connect.dto.SigninRequest;
import com.fas.connect.dto.StudentDTO;
import com.fas.connect.dto.UserDTO;
import com.fas.connect.entities.Course;
import com.fas.connect.entities.Faculty;
import com.fas.connect.entities.Student;
import com.fas.connect.entities.StudentModuleMark;
import com.fas.connect.entities.User;
import com.fas.connect.exception_handler.ResourceNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService{


	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private FacultyRepository facultyRepo;

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModuleRepository moduleRepo;

	@Autowired
	private StudentModuleMarksRepository marksRepo;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public UserDTO signIn(SigninRequest request) {
		User user = userRepo.findByEmail(request.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Faculty not found"));
        return mapper.map(user, UserDTO.class);
	}

	
	//Adding the list of student according course	
	@Override
	public ResponseEntity<?> addStudents(List<StudentDTO> students, long courseId) {

		Course course = courseRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
		for (StudentDTO studentDTO : students) {
			User u1 = studentDTO.getUser();
			u1.getProfileImg();
			studentDTO.getUser().setPassword(passwordEncoder.encode(studentDTO.getUser().getPassword()));
			User user = userRepo.save(studentDTO.getUser());
			Student student = new Student(studentDTO.getRollNo(), user);
			
			String to = student.getUser().getEmail();
			String subject = "Welcome to FASConnect";
	        String text = "Hello " + studentDTO.getUser().getFirstName() +",you have successfully registered in FASConnect.\n" +
	        "Your User Id is " + studentDTO.getRollNo() + ".\n To SignIn use your ID and EmailID " + studentDTO.getUser().getEmail() + " Thank you!";
	        emailService.sendEmail(to, subject, text);
			
			course.addStudent(student);
		}
		String successMessage = "Students added successfully to the course.";
		return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);	
	}
	// To get All users
	@Override
	public List<UserDTO> getAllUsers() {
		List<User> list = userRepo.findAll();
		return list.stream() 
				.map(user-> mapper.map(user, UserDTO.class)) 
				.collect(Collectors.toList());
	}

	//To add faculty
	@Override
	public FacultyDTO addFaculty(FacultyDTO facultyDTO) {
		Faculty faculty = mapper.map(facultyDTO, Faculty.class);
		faculty.getUser().setPassword(passwordEncoder.encode(facultyDTO.getUser().getPassword()));
		Faculty facultyPersist = facultyRepo.save(faculty);
		facultyPersist.setFacultyId("F00"+facultyPersist.getUserId());
		
		String to = faculty.getUser().getEmail();
		String subject = "Welcome to FASConnect";
        String text = "Hello " + faculty.getUser().getFirstName() +",you have successfully registered in FASConnect.\n" +
        "Your User Id is F00" + facultyPersist.getUserId() + ".\n To SignIn use your ID and EmailID " + faculty.getUser().getEmail() + " Thank you!";
        emailService.sendEmail(to, subject, text);

        return mapper.map(facultyRepo.save(facultyPersist), FacultyDTO.class);
	}
	


	//To delete student
	@Override
	public void deleteStudent(Long userId) {
		Student student = studentRepo.findById(userId)
				.orElseThrow();
		Course course = student.getCourse();
		course.removeStudent(student);
		courseRepo.save(course);		
	}
	
	//To delete faculty
	@Override
	public void deleteFaculty(Long id) {
		Faculty faculty = facultyRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculty not found"));
		facultyRepo.delete(faculty);
	}
	
	@Override
	public List<MarksDTO> getMarks(Long id) {
		Student student = studentRepo.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("Student does not exist"));
		
		List<StudentModuleMark> markSheet = student.getStudentModuleMarks();
		
		return markSheet.stream().map(mark -> {
	        MarksDTO marksDTO = mapper.map(mark, MarksDTO.class);
	        marksDTO.setStudentId(mark.getStudent().getUserId());  // Mapping studentId
	        marksDTO.setModuleId(mark.getModule().getId());    // Mapping moduleId
	        return marksDTO;
	    }).collect(Collectors.toList());
	}

	@Override
	public MarksDTO addMarks(MarksDTO marksDTO) {
		StudentModuleMark marks = new StudentModuleMark();
		
		marks.setObtainedMarks(marksDTO.getObtainedMarks());
		marks.setTotalMarks(marksDTO.getTotalMarks());
		
		marks.setStudent(studentRepo.findById(marksDTO.getStudentId()).
									orElseThrow());
		
		
		marks.setModule(moduleRepo.findById(marksDTO.getModuleId()).
									orElseThrow());
		
		MarksDTO returnMarkDTO = mapper.map(marksRepo.save(marks), MarksDTO.class);
		
		returnMarkDTO.setStudentId(marks.getStudent().getUserId());
		returnMarkDTO.setModuleId(marks.getModule().getId());
		
		return returnMarkDTO;
	}
}
