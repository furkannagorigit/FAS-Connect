package com.fas.connect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarksDTO {
	private Integer marks;
	private Long studentId;
	private Long moduleId;
}
