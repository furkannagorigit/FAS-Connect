package com.fas.connect.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fas.connect.entity.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QnADTO {

    private Long id;

	private Post post;

    private String answer;

//	    private List<Comment> comments = new ArrayList<>();

//	    private Faculty answerBy;
}
