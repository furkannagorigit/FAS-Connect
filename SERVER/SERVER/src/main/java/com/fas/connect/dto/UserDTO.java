package com.fas.connect.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fas.connect.entities.Gender;
import com.fas.connect.entities.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
	@NotBlank
	private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String mobile;
    @NotBlank(message = "Email can't be blank")
	@Email(message = "Invalid email format")
    private String email;
    private String password;
}
