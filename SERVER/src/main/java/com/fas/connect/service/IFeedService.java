package com.fas.connect.service;

import java.util.List;

import com.fas.connect.entity.Feed;

public interface IFeedService {

	public List<Feed> getAllFeeds();

    public Feed saveFeed(Feed feed);

    public void deleteFeed(Long id);
}
