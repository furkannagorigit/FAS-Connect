package com.fas.connect.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
	private Long userId;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="user_id")
	@MapsId
	private User user;

	private String rollNo;
	
	@ManyToOne
	Course course;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<StudentModuleMark> studentModuleMarks = new ArrayList<>();
	
}