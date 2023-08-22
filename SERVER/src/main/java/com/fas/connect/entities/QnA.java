package com.fas.connect.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="qna")  
@PrimaryKeyJoinColumn(name="id") 
public class QnA extends Post{
    @Lob
    private String answer;

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL,fetch = FetchType.EAGER) 
	private List<Comment> comments = new ArrayList<>();
    
    @ManyToOne(cascade = CascadeType.ALL) 
    private Faculty answerBy;
    
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

