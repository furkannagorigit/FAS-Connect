package com.fas.connect.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name", length=255)
	private String firstName;
	
	@Column(name="last_name", length=255)
	private String lastName;
	
	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Role role;
	
	@Column(length=10)
	private String mobile;
	
	@Column(length=255, unique = true, nullable = false)
	private String email;
	
	@Column(length=255, nullable = false)
	private String password;
	
	@Lob
	private String profileImg;
	
	@OneToMany(mappedBy = "createdBy", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true,
			fetch = FetchType.EAGER)
	private List<Post> posts = new ArrayList<>();
	
	public void addPost(Post p) {
		posts.add(p);
		p.setCreatedBy(this);
	}
	
	public void deletePost(Post p) {
		posts.remove(p);
		p.setCreatedBy(null);
	}

	}