package com.fas.connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.service.FeedServiceImpl;
import com.fas.connect.service.PostServiceImpl;

@RestController
@RequestMapping("/feed")
public class FeedController {
	//Dependancy Injecion

	//FeedService DI
	@Autowired
	FeedServiceImpl feedService;
	
	//PostService DI
	@Autowired
	PostServiceImpl postService;
	
	//POST mapping to add a Feed record
	@PostMapping("/addFeed/{userId}")
	public ResponseEntity<?> addFeed(@PathVariable Long userId, @RequestBody FeedDTO feedDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(feedService.addFeed(userId, feedDTO));
	}
	
	//DELETE mapping to delete a Feed record
	@DeleteMapping("/deleteFeed/{postId}")
	public ResponseEntity<?> deleteFeed(@PathVariable Long postId){
		postService.deletePost(postId);
		return ResponseEntity.status(HttpStatus.OK).body("Feed removed successfully");
	}
	
	//PUT mapping to edit a Feed record
	@PutMapping("/editFeed/{postId}")
	public ResponseEntity<?> editFeed(@PathVariable Long postId, @RequestBody FeedDTO feedDTO){
		return ResponseEntity.status(HttpStatus.OK).body(feedService.editFeed(postId, feedDTO));
	}
	
}
