package com.fas.connect.dto;

import javax.validation.constraints.NotBlank;

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
	@NotBlank
	private String rollNo;
	private User user;
}
