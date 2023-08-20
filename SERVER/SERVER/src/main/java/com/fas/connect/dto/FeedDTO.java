package com.fas.connect.dto;

import java.time.LocalDateTime;

import com.fas.connect.entities.PostType;
import com.fas.connect.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FeedDTO {
	private String text;
	private LocalDateTime createdAt = LocalDateTime.now();
	private final PostType type = PostType.FEED;
}
