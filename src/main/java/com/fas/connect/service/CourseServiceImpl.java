package com.fas.connect.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import com.fas.connect.dto.CourseDTO;
import com.fas.connect.dto.CourseStudentsDTO;
import com.fas.connect.entities.Course;
import com.fas.connect.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CourseDTO> getAllCourses() {
		
		List<Course> list = courseRepo.findAll();
		return list.stream() 
				.map(course -> mapper.map(course, CourseDTO.class)) 
				.collect(Collectors.toList());
	}

	@Override
	public CourseDTO getCourseDetails(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDTO addNewCourse(CourseDTO course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseStudentsDTO getCourseAndStudentsDetails(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
