package com.fas.connect.controller;

import com.fas.connect.entity.Feed;
import com.fas.connect.service.FeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {

    private final FeedServiceImpl FeedServiceImpl;

    @Autowired
    public FeedController(FeedServiceImpl FeedServiceImpl) {
        this.FeedServiceImpl = FeedServiceImpl;
    }

    @GetMapping
    public List<Feed> getAllFeeds() {
        return FeedServiceImpl.getAllFeeds();
    }

    @PostMapping
    public Feed createFeed(@RequestBody Feed feed) {
        return FeedServiceImpl.saveFeed(feed);
    }

    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable Long id) {
        FeedServiceImpl.deleteFeed(id);
    }
}
