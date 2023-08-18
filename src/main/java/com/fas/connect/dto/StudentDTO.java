package com.fas.connect.dto;

import java.time.LocalDate;


import com.fas.connect.entities.Gender;
import com.fas.connect.entities.Role;
import com.fas.connect.entities.User;

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
public class StudentDTO {
	
	private String rollNo;
	
	private User user;

}
