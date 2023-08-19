package com.fas.connect.controller;


import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.QnADTO;
import com.fas.connect.entity.Post;
import com.fas.connect.entity.QnA;
import com.fas.connect.service.PostServiceImpl;
import com.fas.connect.service.QnAServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qnas")
public class QnAController {

    private final QnAServiceImpl QnAServiceImpl;
    private PostServiceImpl postServiceImpl;
    
    @Autowired
    public QnAController(QnAServiceImpl QnAServiceImpl) {
        this.QnAServiceImpl = QnAServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<QnADTO>> getAllFeeds() {
        List<QnADTO> QnADTOs = QnAServiceImpl.getAllQnAs();
        if (QnADTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(QnADTOs);
    }

    @PostMapping("/addQnA")
    public ResponseEntity<?> createQnA(@RequestBody QnADTO qnaDTO) {
    	Post post = qnaDTO.getPost();
    	postServiceImpl.savePost(post);
    	return ResponseEntity.status(HttpStatus.CREATED).body(QnAServiceImpl.saveQnA(qnaDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteQnA(@PathVariable Long id) {
        QnAServiceImpl.deleteQnA(id);
    }
}
