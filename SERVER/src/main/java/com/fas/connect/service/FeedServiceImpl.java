package com.fas.connect.service;

import com.fas.connect.entity.Feed;
import com.fas.connect.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceImpl {

    private final FeedRepository feedRepository;

    @Autowired
    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public List<Feed> getAllFeeds() {
        return feedRepository.findAll();
    }

    public Feed saveFeed(Feed feed) {
        return feedRepository.save(feed);
    }

    public void deleteFeed(Long id) {
        feedRepository.deleteById(id);
    }
}
