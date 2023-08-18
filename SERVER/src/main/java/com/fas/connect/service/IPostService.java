package com.fas.connect.service;

import java.util.List;

import com.fas.connect.dto.PostDTO;
import com.fas.connect.entity.Post;

public interface IPostService {


    public List<PostDTO> getAllPosts() ;

    public Post getPostById(Long id) ;

    public Post savePost(Post post);

    public void deletePost(Long id);
    
}
