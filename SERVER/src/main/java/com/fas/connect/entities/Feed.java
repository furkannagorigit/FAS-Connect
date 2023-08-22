package com.fas.connect.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity  
@Table(name="feed")  
@PrimaryKeyJoinColumn(name="id")  
public class Feed extends Post {
	
	@JsonIgnore
	@OneToMany(mappedBy = "feedId", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<PostLike> likes = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "postId", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER) 
	private List<Comment> comments = new ArrayList<>();

	public void addLike(User u) {
		PostLike post = new PostLike();
		post.setFeedId(this);
		post.setLikedBy(u);
		likes.add(post);

	}
	public void removeLike(User u) {
	    PostLike likeToRemove = null;
	    for (PostLike like : likes) {
	        if (like.getLikedBy().equals(u)) {
	            likeToRemove = like;
	            break;
	        }
	    }

	    if (likeToRemove != null) {
	        likes.remove(likeToRemove);
	    }
	}
	
	public void addComment(Comment c, User u) {
		comments.add(c);
		c.setPostId(this);
		c.setUser(u);
	}
	public void removeComment(Comment c, User u) {
		comments.remove(c);
		c.setPostId(null);
		c.setUser(null);
	}
}