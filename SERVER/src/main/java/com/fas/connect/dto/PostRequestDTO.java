package com.fas.connect.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fas.connect.entities.Comment;
import com.fas.connect.entities.PostLike;
import com.fas.connect.entities.PostType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostRequestDTO {
	private String text;
	private LocalDateTime createdAt = LocalDateTime.now();
	private final PostType type = PostType.FEED;
    
}
