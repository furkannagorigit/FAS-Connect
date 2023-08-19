package com.fas.connect.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="student")
public class Student {
	
	@Id
    private Long userId;
	
	@Column(unique = true, nullable = false)
	private String rollNo;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="user_id")
	@MapsId
	private User user;
	
	@ManyToOne
	Course course;
	
	@OneToMany
	private List<Feed> feed = new ArrayList<>(); 
	
	public Student(String rollNo, User user)
	{
		this.rollNo = rollNo;
		this.user = user;
	}
}