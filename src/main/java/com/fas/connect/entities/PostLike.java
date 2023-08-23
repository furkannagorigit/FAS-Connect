package com.fas.connect.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@NoArgsConstructor
public class PostLike {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User likedBy;

	    @ManyToOne
	    @JoinColumn(name = "feed_id")
	    private Feed feedId;
	    
	    private LocalDate likedAt;

}
