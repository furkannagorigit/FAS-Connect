package com.fas.connect.service;

import java.util.List;

import com.fas.connect.dto.AnswerReqDTO;
import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.dto.QnAResponseDTO;

public interface QnAService {

	 public List<QnAResponseDTO> getAllQnAs();

	    public PostDTO addQnA(Long userId, PostDTO qnaDTO) ;

	    public PostDTO editQnA(Long postId, PostDTO announcementDTO) ;
	    
	    ApiResponse commentQnA(CommentDTO commentDTO);
		ApiResponse uncommentQnA(Long commentId);

		QnAResponseDTO addAnswer(Long qnaId, AnswerReqDTO answerReqDTO);
}