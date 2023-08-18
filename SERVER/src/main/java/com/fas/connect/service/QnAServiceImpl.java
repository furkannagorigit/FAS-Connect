package com.fas.connect.service;

import com.fas.connect.entity.QnA;
import com.fas.connect.repository.QnARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnAServiceImpl {

    private final QnARepository qnARepository;

    @Autowired
    public QnAServiceImpl(QnARepository qnARepository) {
        this.qnARepository = qnARepository;
    }

    public List<QnA> getAllQnAs() {
        return qnARepository.findAll();
    }

    public QnA saveQnA(QnA qna) {
        return qnARepository.save(qna);
    }

    public void deleteQnA(Long id) {
        qnARepository.deleteById(id);
    }
}
