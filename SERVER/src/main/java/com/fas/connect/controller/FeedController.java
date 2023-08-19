package com.fas.connect.controller;

import com.fas.connect.dto.AnnouncementDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.entity.Feed;
import com.fas.connect.entity.Post;
import com.fas.connect.service.FeedServiceImpl;
import com.fas.connect.service.PostServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {

    private final FeedServiceImpl feedServiceImpl;
    private PostServiceImpl postServiceImpl;
    
    @Autowired
    public FeedController(FeedServiceImpl FeedServiceImpl) {
        this.feedServiceImpl = FeedServiceImpl;
    }
    
    @GetMapping
    public ResponseEntity<List<FeedDTO>> getAllFeeds() {
        List<FeedDTO> feedDTOs = feedServiceImpl.getAllFeeds();
        if (feedDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(feedDTOs);
    }

    @PostMapping("/addFeed/{userId}")
    public ResponseEntity<?> createFeed(@RequestBody FeedDTO feedDTO,@PathVariable Long userId) {
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(feedServiceImpl.saveFeed(feedDTO,userId));
    }

    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable Long id) {
    	FeedDTO feedDTO = feedServiceImpl.getFeedbyId(id);
    	  	
    	
//    	feedServiceImpl.deleteFeed
//    	
    }
}
