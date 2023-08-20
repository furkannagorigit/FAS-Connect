package com.fas.connect.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity  
@Table(name="feed")  
@PrimaryKeyJoinColumn(name="id")  
public class Feed extends Post {
	
//	@OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
//  private Set<Like> likes = new HashSet<>();
//
//  @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL) 
//  private List<Comment> comments = new ArrayList<>();
}
