package com.fas.connect.service;

import java.util.List;

import com.fas.connect.dto.FeedDTO;
import com.fas.connect.entity.Feed;

public interface IFeedService {

	public List<FeedDTO> getAllFeeds();

    public FeedDTO saveFeed(FeedDTO feedDTO,Long userId);

    public FeedDTO getFeedbyId(Long id) ;
    
    public void deleteFeed(Long id);
}
