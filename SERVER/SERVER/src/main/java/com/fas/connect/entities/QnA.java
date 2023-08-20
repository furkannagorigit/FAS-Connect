package com.fas.connect.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity  
@Table(name="qna")  
@PrimaryKeyJoinColumn(name="id") 
public class QnA extends Post {
	
	@Lob
    @Column(name = "answer")
    private String answer;
	
//  @OneToMany(mappedBy = "qna", cascade = CascadeType.ALL) // Apply cascading
//  private List<Comment> comments = new ArrayList<>();
//
	@ManyToOne
	private Faculty answeredBy;
}
