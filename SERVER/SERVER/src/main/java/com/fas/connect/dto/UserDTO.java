package com.fas.connect.dto;

import java.time.LocalDate;

import com.fas.connect.entities.Gender;
import com.fas.connect.entities.Role;

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
