package com.fas.connect.dto;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fas.connect.entity.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FeedDTO {

	    private Long id;

	    private Post post;

//	    private Set<Like> likes = new HashSet<>();
 
//	    private List<Comment> comments = new ArrayList<>();
}
