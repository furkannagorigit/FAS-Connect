package com.fas.connect.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fas.connect.custom_exceptions.ResourceNotFoundException;
import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.dto.MarksDTO;
import com.fas.connect.dto.StudentDTO;
import com.fas.connect.dto.UserDTO;
import com.fas.connect.entities.Course;
import com.fas.connect.entities.Faculty;
import com.fas.connect.entities.Student;
import com.fas.connect.entities.StudentModuleMark;
import com.fas.connect.entities.User;
import com.fas.connect.repository.CourseRepository;
import com.fas.connect.repository.FacultyRepository;
import com.fas.connect.repository.ModuleRepository;
import com.fas.connect.repository.StudentModuleMarksRepository;
import com.fas.connect.repository.StudentRepository;
import com.fas.connect.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	//Dependancy Injecion

	//UserRepository DI
	@Autowired
	private UserRepository userRepo;

	//FacultyRepository DI
	@Autowired
	private FacultyRepository facultyRepo;

	//StudentRepository DI
	@Autowired
	private StudentRepository studentRepo;

	//CourseRepository DI
	@Autowired
	private CourseRepository courseRepo;

	//StudentModuleMark DI
	@Autowired
	private StudentModuleMarksRepository marksRepo;
	
	//ModuleRepository DI
	@Autowired
	private ModuleRepository moduleRepo;

	//ModelMapperDI
	@Autowired
	private ModelMapper modelMapper;

	//Service to get the list of users
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	//	//Service to edit user details
	//	@Override
	//	public User editUser(Long id, UserDTO userDTO) {
	//		User user = userRepo.findById(id)
	//				.orElseThrow(() -> new RuntimeException("Faculty not found"));
	//
	//		user = modelMapper.map(userDTO, User.class);
	//		return userRepo.save(user);
	//	}

	//Service to add a faculty record
	@Override
	public FacultyDTO addFaculty(FacultyDTO facultyDTO) {
		Faculty faculty = modelMapper.map(facultyDTO, Faculty.class);
		return modelMapper.map(facultyRepo.save(faculty), FacultyDTO.class);
	}

	//Service to edit faculty details
	@Override
	public FacultyDTO editFaculty(Long id, FacultyDTO facultyDTO) {
		Faculty faculty = facultyRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculty not found"));
		modelMapper.map(facultyDTO, faculty);				
		return modelMapper.map(facultyRepo.save(faculty), FacultyDTO.class);
	}

	//Service to edit student details
	@Override
	public StudentDTO editStudent(Long id, StudentDTO studentDTO) {
		Student student = studentRepo.findById(id)
				.orElseThrow();
		modelMapper.map(studentDTO, student);

		System.out.println(student.getCourse().findStudent(student).getUser().getFirstName());

		return modelMapper.map(studentRepo.save(student), StudentDTO.class);
	}

	//	//Service to edit student details
	//	@Override
	//	public StudentDTO editStudent(Long id, StudentDTO studentDTO) {
	//		Student student = studentRepo.findById(id)
	//				.orElseThrow();
	//		Course course = student.getCourse();
	//		
	//		Student foundStudent = course.findStudent(student);
	//		
	//	}

	//Service to delete a faculty record
	@Override
	public void deleteFaculty(Long id) {
		Faculty faculty = facultyRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Faculty not found"));
		facultyRepo.delete(faculty);
	}

	//	//Service to delete a student record
	//	@Override
	//	public void deleteStudent(Long id) {
	//		Student student = studentRepo.findById(id)
	//				.orElseThrow(() -> new RuntimeException("Student not found"));
	//		studentRepo.delete(student);
	//	}

	@Override
	public ResponseEntity<?> AddStudentsToCourse(List<StudentDTO> students, long courseId) {

		Course course = courseRepo.findById(courseId).orElseThrow();
		for (StudentDTO studentDTO : students) {
			User user = userRepo.save(studentDTO.getUser());
			Student student = new Student(studentDTO.getRollNo(), user);
			course.addStudent(student);

		}
		String successMessage = "Students added successfully to the course.";
		return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);	
	}

	//Service to delete a student record
	@Override
	public void deleteStudent(Long userId) {

		Student student = studentRepo.findById(userId)
				.orElseThrow();

		Course course = student.getCourse();

		course.removeStudent(student);

		courseRepo.save(course);
	}


	@Override
	public List<MarksDTO> getMarks(Long id) {
		Student student = studentRepo.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("Student does not exist"));
		
		List<StudentModuleMark> markSheet = student.getStudentModuleMarks();
		
		return markSheet.stream().map(mark -> {
	        MarksDTO marksDTO = modelMapper.map(mark, MarksDTO.class);
	        marksDTO.setStudentId(mark.getStudent().getUserId());  // Mapping studentId
	        marksDTO.setModuleId(mark.getModule().getId());    // Mapping moduleId
	        return marksDTO;
	    }).collect(Collectors.toList());
	}

	@Override
	public MarksDTO addMarks(MarksDTO marksDTO) {
		StudentModuleMark marks = new StudentModuleMark();
		
		marks.setMarks(marksDTO.getMarks());
		System.out.println(marks.getMarks());
		
		marks.setStudent(studentRepo.findById(marksDTO.getStudentId()).
									orElseThrow());
		
		marks.setModule(moduleRepo.findById(marksDTO.getModuleId()).
									orElseThrow());
		
		MarksDTO returnMarkDTO = modelMapper.map(marksRepo.save(marks), MarksDTO.class);
		
		returnMarkDTO.setStudentId(marks.getStudent().getUserId());
		returnMarkDTO.setModuleId(marks.getModule().getId());
		
		return returnMarkDTO;
	}
}
