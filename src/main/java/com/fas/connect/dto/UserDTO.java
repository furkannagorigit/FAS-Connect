package com.fas.connect.dto;

import java.time.LocalDate;


import com.fas.connect.entities.Gender;
import com.fas.connect.entities.Role;

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
public class UserDTO {
	
	private Long id;

	private String firstName;

	private String lastName;

	private LocalDate dateOfBirth;

	private Gender gender;

	private Role role;

	private String mobile;

	private String email;

	private String password;
	
	private String profileImg;
}
