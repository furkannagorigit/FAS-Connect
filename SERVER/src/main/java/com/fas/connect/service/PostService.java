package com.fas.connect.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostService {


//    public List<PostDTO> getAllPosts() ;
    public Page<PostDTO> getAllPosts(Pageable pageable);
	void deletePost(Long postId);

    
}