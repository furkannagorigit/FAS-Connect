package com.fas.connect.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fas.connect.custom_exceptions.ResourceNotFoundException;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.User;
import com.fas.connect.repository.PostRepository;
import com.fas.connect.repository.UserRepository;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	//Dependancies
	
	//PostRepository DI
	@Autowired
	PostRepository postRepo;
	
	//UserRepository DI
	@Autowired 
	UserRepository userRepo;
	
	//ModelMapper DI
	@Autowired
	ModelMapper modelMapper;
	
	//Service to Delete a post
	@Override
	public void deletePost(Long postId) {
		System.out.println(postId);
		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post Not Found"));
		User user = post.getCreatedBy();
		user.deletePost(post);
		user.getPosts().size();
	}	
	
}