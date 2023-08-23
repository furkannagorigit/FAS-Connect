package com.fas.connect.controller;

import com.fas.connect.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.FeedLikeRequest;
import com.fas.connect.dto.FeedResponseDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.service.FeedService;
import com.fas.connect.service.FeedServiceImpl;
import com.fas.connect.service.ImageHandlingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/feeds")
public class FeedController {

	@Autowired
	private FeedService feedService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ImageHandlingService imageService;

//	@GetMapping
//	public ResponseEntity<List<FeedResponseDTO>> getAllFeeds() {
//		List<FeedResponseDTO> feedDTOs = feedService.getAllFeeds();
//		if (feedDTOs.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.ok(feedDTOs);
//	}

	
	@GetMapping
    public ResponseEntity<Page<FeedResponseDTO>> getAllFeeds(Pageable pageable) {
        Page<FeedResponseDTO> feedDTOPage = feedService.getAllFeeds(pageable);
        if (feedDTOPage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(feedDTOPage);
    }
	
	@PostMapping("/like")
	public ResponseEntity<?> likeFeed(@RequestBody FeedLikeRequest likeDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(feedService.likeFeed(likeDTO.getUserId(),likeDTO.getPostId()));
	}

	@PostMapping("/dislike")
	public ResponseEntity<?> disLikeFeed(@RequestBody FeedLikeRequest likeDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(feedService.disLikeFeed(likeDTO.getUserId(),likeDTO.getPostId()));
	}

	@PostMapping("/comment")
	public ResponseEntity<?> commentFeed(@RequestBody CommentDTO commentDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(feedService.commentFeed(commentDTO));
	}

	@PostMapping("/uncomment/{id}")
	public ResponseEntity<?> uncommentFeed(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(feedService.uncommentFeed(id));
	}


//	@PostMapping("/{userId}")
//	public ResponseEntity<?> createFeed(@RequestBody FeedDTO feedDTO,@PathVariable Long userId) {
//		System.out.println(feedDTO.toString());
//		return ResponseEntity.status(HttpStatus.CREATED).body(feedService.addFeed(userId,feedDTO));
//	}

	@PostMapping(value = "/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<FeedDTO> handleUpload(
			@PathVariable("id") Long userId,
			@RequestParam("feed") String feed,
			@RequestParam("imageFile") MultipartFile imageFile) throws JsonMappingException, JsonProcessingException

	{
		System.out.println(imageFile.getOriginalFilename());
		FeedDTO feedDTO = objectMapper.readValue(feed, FeedDTO.class);
		feedDTO = imageService.addImageInFeed(feedDTO, imageFile);
		return ResponseEntity.status(HttpStatus.CREATED).body(feedService.addFeed(userId, feedDTO));        
	}

	@DeleteMapping("/{id}")
	public void deleteFeed(@PathVariable Long id) {
		FeedResponseDTO feedDTO = feedService.getFeedbyId(id);


	}
}