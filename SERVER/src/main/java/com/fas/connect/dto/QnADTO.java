package com.fas.connect.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fas.connect.entities.Post;
import com.fas.connect.entities.PostType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class QnADTO {
	
	private String text;
	private LocalDateTime createdAt = LocalDateTime.now();
	private final PostType type = PostType.QNA;
    private String answer;

}
