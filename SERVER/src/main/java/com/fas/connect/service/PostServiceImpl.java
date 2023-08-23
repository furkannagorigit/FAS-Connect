package com.fas.connect.service;


import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.User;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.PostRepository;
import com.fas.connect.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
    private PostRepository postRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
    private ModelMapper modelMapper;

//    public List<PostDTO> getAllPosts() {
//        List<Post> posts = postRepo.findAll();
//        return posts.stream()
//            .map(post -> modelMapper.map(post, PostDTO.class))
//            .collect(Collectors.toList());
//    }
    @Override
    public Page<PostDTO> getAllPosts(Pageable pageable) {
        Page<Post> posts = postRepo.findAll(pageable);
        return posts.map(post -> modelMapper.map(post, PostDTO.class));
    }

    @Override
	public void deletePost(Long postId) {
		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post Not Found"));
		User user = post.getCreatedBy();
		user.deletePost(post);
		userRepo.save(user);
	}	
}