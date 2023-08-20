package com.fas.connect.entities;

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
@Table(name="announcement")  
@PrimaryKeyJoinColumn(name="id") 
public class Announcement extends Post {
	
}
