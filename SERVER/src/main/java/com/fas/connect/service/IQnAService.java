package com.fas.connect.service;

import java.util.List;

import com.fas.connect.dto.QnADTO;
import com.fas.connect.entity.QnA;

public interface IQnAService {

	 public List<QnADTO> getAllQnAs();

	    public QnADTO saveQnA(QnADTO qnaDTO) ;

	    public void deleteQnA(Long id) ;
}
