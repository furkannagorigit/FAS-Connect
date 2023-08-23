package com.fas.connect.service;

import org.springframework.web.multipart.MultipartFile;

import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.FeedDTO;



public interface ImageHandlingService {
	ApiResponse uploadImage(Long userId, MultipartFile image);
	FeedDTO addImageInFeed(FeedDTO feedDTO, MultipartFile image);
}
