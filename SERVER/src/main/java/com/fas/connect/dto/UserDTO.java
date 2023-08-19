package com.fas.connect.dto;

import java.time.LocalDate;

import com.fas.connect.entity.Gender;
import com.fas.connect.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
	private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String mobile;
    private String email;
    private String password;
}