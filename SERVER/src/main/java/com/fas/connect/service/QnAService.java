package com.fas.connect.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.dto.QnAResponseDTO;

public interface QnAService {

//	 public List<QnAResponseDTO> getAllQnAs();
	
	public Page<QnAResponseDTO> getAllQnAs(Pageable pageable);

	    public PostDTO addQnA(Long userId, PostDTO qnaDTO) ;

	    public PostDTO editQnA(Long postId, PostDTO announcementDTO) ;
	    
	    ApiResponse commentQnA(CommentDTO commentDTO);
		ApiResponse uncommentQnA(Long commentId);
}