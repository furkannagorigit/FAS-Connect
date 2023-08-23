package com.fas.connect.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import com.fas.connect.dto.CourseDTO;
import com.fas.connect.dto.CourseStudentsDTO;
import com.fas.connect.dto.ModuleDTO;
import com.fas.connect.entities.Course;
import com.fas.connect.entities.Module;
import com.fas.connect.repository.CourseRepository;
import com.fas.connect.repository.ModuleRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModuleRepository moduleRepo;

	@Autowired
	private ModelMapper mapper;

	//get all courses
	@Override
	public List<CourseDTO> getAllCourses() {

		List<Course> list = courseRepo.findAll();
		return list.stream() 
				.map(course -> mapper.map(course, CourseDTO.class)) 
				.collect(Collectors.toList());
	}
	// get a single course
	@Override
	public CourseDTO getCourseDetails(Long courseId) {
		Course course=courseRepo.findById(courseId).
				orElseThrow();
		System.out.println(course.getModules().size());
		return mapper.map(course,CourseDTO.class);
	}

	@Override
	public CourseDTO addNewCourse(CourseDTO courseDTO) {
		Course course= mapper.map(courseDTO, Course.class);
		Course persistentCourse = courseRepo.save(course);
		return mapper.map(persistentCourse, CourseDTO.class);
	}


	@Override
	public CourseStudentsDTO getCourseAndStudentsDetails(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModuleDTO addNewModule(@Valid ModuleDTO moduleDTO) {
		Module module= mapper.map(moduleDTO, Module.class);
		Module persistentModule = moduleRepo.save(module);
		return mapper.map(persistentModule, ModuleDTO.class);
	}

}
