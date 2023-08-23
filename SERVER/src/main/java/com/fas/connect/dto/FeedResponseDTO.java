package com.fas.connect.dto;

import java.util.ArrayList;
import java.util.List;

import com.fas.connect.entities.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class FeedResponseDTO {
	private Long id;
	private FeedDTO feed;
	private int likes;
	private List<Comment> comments = new ArrayList<Comment>();
}
