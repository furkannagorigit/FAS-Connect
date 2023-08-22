package com.fas.connect.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentsDTO {
	private Long id;

	private String courseName;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private List<UserDTO> emps;


}
