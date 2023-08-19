package com.fas.connect.service;

import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.QnADTO;
import com.fas.connect.entity.Feed;
import com.fas.connect.entity.QnA;
import com.fas.connect.repository.QnARepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QnAServiceImpl implements IQnAService{

    private final QnARepository qnARepository;

    @Autowired
    public QnAServiceImpl(QnARepository qnARepository) {
        this.qnARepository = qnARepository;
    }
    
    @Autowired
    private ModelMapper modelMapper;

    public List<QnADTO> getAllQnAs() {
        List<QnA> qnas = qnARepository.findAll();
        return qnas.stream()
            .map(post -> modelMapper.map(post, QnADTO.class))
            .collect(Collectors.toList());
    }


    public QnADTO saveQnA(QnADTO qnaDTO) {
        	QnA qna = modelMapper.map(qnaDTO, QnA.class);
        	return modelMapper.map(qnARepository.save(qna), QnADTO.class);
    }

    public void deleteQnA(Long id) {
        qnARepository.deleteById(id);
    }
}
