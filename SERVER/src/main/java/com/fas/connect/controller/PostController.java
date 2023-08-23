package com.fas.connect.controller;

import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Post;
import com.fas.connect.service.PostService;
import com.fas.connect.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

//    @GetMapping
//    public ResponseEntity<?> getAllPosts() {
//        List<PostDTO> postDTOs = postServiceImpl.getAllPosts();
//        if (postDTOs.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//        return ResponseEntity.ok(postDTOs);
//    }
    
    @GetMapping
    public ResponseEntity<Page<PostDTO>> getAllPosts(Pageable pageable) {
        Page<PostDTO> postDTOPage = postService.getAllPosts(pageable);
        return ResponseEntity.ok(postDTOPage);
    }



    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}