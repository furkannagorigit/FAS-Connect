package com.fas.connect.service;

import java.util.List;

import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.FeedResponseDTO;
import com.fas.connect.dto.PostRequestDTO;
import com.fas.connect.entities.Feed;
import com.fas.connect.entities.User;
public interface FeedService {

	public List<FeedResponseDTO> getAllFeeds();
	PostRequestDTO editFeed(Long postId, PostRequestDTO feedDTO);
	PostRequestDTO addFeed(Long userId, PostRequestDTO feedDTO);
	ApiResponse likeFeed(Long user,Long feed);
	ApiResponse disLikeFeed(Long user, Long feed);
	ApiResponse commentFeed(CommentDTO commentDTO);
	ApiResponse uncommentFeed(Long commentId);

}