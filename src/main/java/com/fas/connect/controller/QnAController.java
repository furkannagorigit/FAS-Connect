package com.fas.connect.controller;

import com.fas.connect.dto.AnswerReqDTO;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.dto.QnAResponseDTO;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.QnA;
import com.fas.connect.service.PostService;
import com.fas.connect.service.QnAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qnas")
public class QnAController {
	@Autowired
    private QnAService qnaService;

	@GetMapping
    public ResponseEntity<List<QnAResponseDTO>> getAllQnAs() {
        List<QnAResponseDTO> QnADTOs = qnaService.getAllQnAs();
        if (QnADTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(QnADTOs);
    }

	@PatchMapping("/addAnswer/{qnaId}")
	public ResponseEntity<?> addAnswer(@PathVariable Long qnaId, @RequestBody AnswerReqDTO answerReqDTO){
		return ResponseEntity.status(HttpStatus.OK).body(qnaService.addAnswer(qnaId, answerReqDTO));
	}
	
    @PostMapping("/addQnA/{userId}")
    public ResponseEntity<?> addQnA(@RequestBody PostDTO qnaDTO,@PathVariable Long userId) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(qnaService.addQnA(userId,qnaDTO));
    }

    @PutMapping("/editQnA/{postId}")
    public ResponseEntity<?> editQnA(@RequestBody  PostDTO qnaDTO,@PathVariable Long postId) {
    	System.out.println(qnaDTO.toString());
    	return ResponseEntity.status(HttpStatus.CREATED).body(qnaService.editQnA(postId,qnaDTO));

    }
    
    @PostMapping("/commentQnA/comment")
    public ResponseEntity<?> commentFeed(@RequestBody CommentDTO commentDTO) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(qnaService.commentQnA(commentDTO));
    }
    
	@PostMapping("/uncommentQnA/{id}")
    public ResponseEntity<?> uncommentFeed(@PathVariable Long id) {
    	return ResponseEntity.status(HttpStatus.OK).body(qnaService.uncommentQnA(id));
    }
    
}