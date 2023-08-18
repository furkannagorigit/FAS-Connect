package com.fas.connect.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="student")
@ToString
public class Student {
	public Student(String rollNo, User user)
	{
		this.rollNo = rollNo;
		this.user = user;
	}
	@Id
	private String rollNo;
	
	@OneToOne
	private User user;

	@ManyToOne
	Course course;
	
}