package com.fas.connect.service;

import com.fas.connect.dto.FeedDTO;

public interface FeedService {
	//Service to add a feed
	FeedDTO addFeed(Long userId, FeedDTO feedDTO);
	
	//Service to edit a feed
	FeedDTO editFeed(Long postId, FeedDTO feedDTO);
}
