package com.fas.connect.dto;

import java.time.LocalDate;

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
public class CourseDTO {
	private Long id;

	private String courseName;
	
	private String courseDetails;
	
	private LocalDate startDate;
	
	private LocalDate endDate;

}
