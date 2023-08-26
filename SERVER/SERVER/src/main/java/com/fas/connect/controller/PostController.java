package com.fas.connect.controller;

import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Post;
import com.fas.connect.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostServiceImpl postServiceImpl;

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        List<PostDTO> postDTOs = postServiceImpl.getAllPosts();
        if (postDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(postDTOs);
    }

    

 
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return null;
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postServiceImpl.deletePost(id);
    }
}