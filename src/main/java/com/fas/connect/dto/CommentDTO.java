package com.fas.connect.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentDTO {
	private long commentId;
	private long userId;
	private long postId;
	private String text;
}
