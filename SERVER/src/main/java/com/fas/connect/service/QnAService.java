package com.fas.connect.service;

import java.util.List;

import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.PostRequestDTO;
import com.fas.connect.dto.QnADTO;
import com.fas.connect.entities.QnA;

public interface QnAService {

	 public List<QnADTO> getAllQnAs();

	    public PostRequestDTO addQnA(Long userId, PostRequestDTO qnaDTO) ;

	    public QnADTO editQnA(Long postId, QnADTO announcementDTO) ;
	    
	    ApiResponse commentQnA(CommentDTO commentDTO);
		ApiResponse uncommentQnA(Long commentId);
}
