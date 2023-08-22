package com.fas.connect.controller;

import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.FeedLikeRequest;
import com.fas.connect.dto.FeedResponseDTO;
import com.fas.connect.dto.PostRequestDTO;
import com.fas.connect.service.FeedService;
import com.fas.connect.service.FeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feeds")
public class FeedController {

	@Autowired
    private FeedService feedService;
     
    @GetMapping
    public ResponseEntity<List<FeedResponseDTO>> getAllFeeds() {
        List<FeedResponseDTO> feedDTOs = feedService.getAllFeeds();
        if (feedDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(feedDTOs);
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
    

    @PostMapping("/addFeed/{userId}")
    public ResponseEntity<?> addFeed(@RequestBody PostRequestDTO feedDTO,@PathVariable Long userId) {

    	System.out.println(feedDTO.toString());
    	return ResponseEntity.status(HttpStatus.CREATED).body(feedService.addFeed(userId,feedDTO));
    }
 
    @PutMapping("/editFeed/{postId}")
    public ResponseEntity<?> editFeed(@RequestBody  PostRequestDTO feedDTO,@PathVariable Long postId) {
    	System.out.println(feedDTO.toString());
    	return ResponseEntity.status(HttpStatus.CREATED).body(feedService.editFeed(postId,feedDTO));

    }
}