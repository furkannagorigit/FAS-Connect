package com.fas.connect.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FeedLikeRequest {

	private Long postId;
	private Long UserId;
}
