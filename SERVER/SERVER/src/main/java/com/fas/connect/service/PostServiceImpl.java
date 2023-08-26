package com.fas.connect.service;

import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.User;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.PostRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
    private PostRepository postRepo;
    
	@Autowired
    private ModelMapper modelMapper;

    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream()
            .map(post -> modelMapper.map(post, PostDTO.class))
            .collect(Collectors.toList());
    }

    public ResponseEntity<?> savePost(Post post) {
        return null;
    }

    @Override
	public void deletePost(Long postId) {
		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post Not Found"));
		User user = post.getCreatedBy();
		user.deletePost(post);
	}	
}