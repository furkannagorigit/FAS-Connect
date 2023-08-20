package com.fas.connect.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fas.connect.custom_exceptions.ResourceNotFoundException;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.entities.Feed;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.User;
import com.fas.connect.repository.FeedRepository;
import com.fas.connect.repository.UserRepository;

@Service
@Transactional
public class FeedServiceImpl implements FeedService {

	//Dependency Injection

	//FeedRepository DI
	@Autowired
	FeedRepository feedRepo;

	//UserRepository DI
	@Autowired
	UserRepository userRepo;

	//ModelMapper DI
	@Autowired
	ModelMapper modelMapper;

	@Override
	public FeedDTO addFeed(Long userId, FeedDTO feedDTO) {
		Feed feed = modelMapper.map(feedDTO, Feed.class);
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		feed.setCreatedBy(user);
		user.addPost(feed);
		return modelMapper.map(feedRepo.save(feed), FeedDTO.class);
	}

	@Override
	public FeedDTO editFeed(Long postId, FeedDTO feedDTO) {
		Feed feed = feedRepo.findById(postId)
				.orElseThrow(()-> new RuntimeException());

		User user = feed.getCreatedBy();
		
		System.out.println("user found");
		
		//Find post from list of posts in user
		Post postInUser = user.getPosts().stream()
				.filter(myPost-> myPost.equals(feed))
				.findFirst().orElseThrow();
		
		System.out.println("post found");
		
		//remove post from list
		user.deletePost(postInUser);
		
		//
		modelMapper.map(feedDTO, feed);
		feed.setId(postId);

		System.out.println("feed id set");

		user.addPost((Post)feed);

		System.out.println("feed added to user");

		return modelMapper.map(feed, FeedDTO.class);
	}
}
