package com.fas.connect.dto;

import com.fas.connect.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString(exclude = "password")
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDTO {
	private String facultyId;
	private User user;
}