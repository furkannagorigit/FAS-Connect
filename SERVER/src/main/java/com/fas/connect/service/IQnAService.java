package com.fas.connect.service;

import java.util.List;

import com.fas.connect.entity.QnA;

public interface IQnAService {

	 public List<QnA> getAllQnAs();

	    public QnA saveQnA(QnA qna) ;

	    public void deleteQnA(Long id) ;
}
