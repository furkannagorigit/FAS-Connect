package com.fas.connect.service;

import java.util.List;
import com.fas.connect.dto.CourseDTO;
import com.fas.connect.dto.CourseStudentsDTO;
import com.fas.connect.dto.ModuleDTO;

public interface CourseService {
	List<CourseDTO> getAllCourses();
	CourseDTO getCourseDetails(Long courseId);
	CourseDTO addNewCourse(CourseDTO course);
	CourseStudentsDTO getCourseAndStudentsDetails(Long courseId);
	ModuleDTO addNewModule(ModuleDTO dto);
	
}
