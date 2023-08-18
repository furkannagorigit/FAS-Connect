package com.fas.connect.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "module")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString(exclude = {"modules", "students"})

public class Module {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING) 
	@Column(length = 30)
	private ModuleName moduleName;
	
	
	@ManyToMany(mappedBy = "modules")
	private List<Course> courses = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="module_faculty",
	joinColumns = @JoinColumn(name="module_id"),
	inverseJoinColumns = @JoinColumn(name="faculty_id")
	)
	private Set<Faculty> faculties = new HashSet<>();		

	
}
