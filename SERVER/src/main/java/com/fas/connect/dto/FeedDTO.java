package com.fas.connect.dto;

import java.time.LocalDateTime;
import com.fas.connect.entities.PostType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class FeedDTO {
	private String text;
	private LocalDateTime createdAt = LocalDateTime.now();
	private final PostType type = PostType.FEED;
	private String feedImg;

   
}
