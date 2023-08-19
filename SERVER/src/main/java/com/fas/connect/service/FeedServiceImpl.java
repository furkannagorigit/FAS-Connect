package com.fas.connect.service;

import com.fas.connect.dto.AnnouncementDTO;
import com.fas.connect.dto.FacultyDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.entity.Announcement;
import com.fas.connect.entity.Faculty;
import com.fas.connect.entity.Feed;
import com.fas.connect.entity.User;
import com.fas.connect.repository.FeedRepository;
import com.fas.connect.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedServiceImpl implements IFeedService{
	@Autowired
    private FeedRepository feedRepository;
    @Autowired
    private UserRepository userRepository;
  
    
    @Autowired
    private ModelMapper modelMapper;

    public List<FeedDTO> getAllFeeds() {
        List<Feed> feeds = feedRepository.findAll();
        return feeds.stream()
            .map(post -> modelMapper.map(post, FeedDTO.class))
            .collect(Collectors.toList());
    }

    public FeedDTO saveFeed(FeedDTO feedDTO,Long userId) {
    	User user=userRepository.findById(userId).orElseThrow();
    	Feed feed = modelMapper.map(feedDTO, Feed.class);
    	
    	user.addPost(feed.getPost());
    	return modelMapper.map(feedRepository.save(feed), FeedDTO.class);
    }


    public void deleteFeed(Long id) {
        feedRepository.deleteById(id);
    }

	@Override
	public FeedDTO getFeedbyId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	public Feed getFeedbyId(Long id) {
//		// TODO Auto-generated method stub
//		 
//		 return feedRepository.findById(id).orElseThrow();
//	}

	
}
