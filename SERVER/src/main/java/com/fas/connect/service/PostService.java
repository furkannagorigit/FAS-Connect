package com.fas.connect.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.fas.connect.dto.PostDTO;

public interface PostService {

	public Page<PostDTO> getAllPosts(Pageable pageable);

//    public List<PostDTO> getAllPosts() ;
    
	void deletePost(Long postId);

    
}