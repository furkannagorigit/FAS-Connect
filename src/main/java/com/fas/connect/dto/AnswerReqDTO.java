package com.fas.connect.dto;



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