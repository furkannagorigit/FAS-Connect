package com.fas.connect.dto;
import com.fas.connect.entities.User;
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
public class StudentDTO {
	
	private String rollNo;
	
	private User user;
	

}
