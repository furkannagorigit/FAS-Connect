package com.fas.connect.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Post;

public interface PostService {


    public List<PostDTO> getAllPosts() ;

    public ResponseEntity<?> savePost(Post post);
    
	void deletePost(Long postId);

    
}