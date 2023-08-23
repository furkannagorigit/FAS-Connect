package com.fas.connect.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.FeedResponseDTO;
public interface FeedService {

//	public List<FeedResponseDTO> getAllFeeds();1
	public Page<FeedResponseDTO> getAllFeeds(Pageable pageable);
	FeedDTO editFeed(Long postId, FeedDTO feedDTO);
	FeedDTO addFeed(Long userId, FeedDTO feedDTO);
	ApiResponse likeFeed(Long user,Long feed);
	ApiResponse disLikeFeed(Long user, Long feed);
	ApiResponse commentFeed(CommentDTO commentDTO);
	ApiResponse uncommentFeed(Long commentId);

}