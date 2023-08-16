package com.fas.connect.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name="faculty")
public class Faculty {
	@Id
	@Column(name="faculty_id")
	private String facultyId;
	
	@OneToOne
	private User user;
	
//	@OneToMany
//	private List<Post> posts = new ArrayList<>();
	
//	@ManyToMany
//	private List<Module> modules = new ArrayList<Module>();
}
