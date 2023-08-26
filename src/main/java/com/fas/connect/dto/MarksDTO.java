package com.fas.connect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MarksDTO {
	private Integer obtainedMarks;
	private Integer totalMarks;
	private Long studentId;
	private Long moduleId;
}