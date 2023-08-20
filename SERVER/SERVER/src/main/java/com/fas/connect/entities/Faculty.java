package com.fas.connect.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@ToString
@Table(name="faculty")
public class Faculty {
	
	@Id
    private Long userId;
	
	@Column(unique = true, nullable = false)
	private String facultyId;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="user_id")
	@MapsId
	private User user;
	
	@OneToMany
	private List<QnA> posts = new ArrayList<>();
	
	@ManyToMany
	private List<Module> modules = new ArrayList<Module>();
}
