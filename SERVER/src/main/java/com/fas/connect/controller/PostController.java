package com.fas.connect.controller;

import com.fas.connect.dto.PostDTO;
import com.fas.connect.entity.Post;
import com.fas.connect.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostServiceImpl postServiceImpl;

    @Autowired
    public PostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> postDTOs = postServiceImpl.getAllPosts();
        if (postDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(postDTOs);
    }

    

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postServiceImpl.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postServiceImpl.savePost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        
        return postServiceImpl.savePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postServiceImpl.deletePost(id);
    }
}
