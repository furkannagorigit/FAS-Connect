package com.fas.connect.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fas.connect.entities.Comment;
import com.fas.connect.entities.PostType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AnswerReqDTO {
	private String Answer;
	private Long AnsweredById;	
}
