package com.fas.connect.controller;

import com.fas.connect.entity.QnA;
import com.fas.connect.service.QnAServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qnas")
public class QnAController {

    private final QnAServiceImpl QnAServiceImpl;

    @Autowired
    public QnAController(QnAServiceImpl QnAServiceImpl) {
        this.QnAServiceImpl = QnAServiceImpl;
    }

    @GetMapping
    public List<QnA> getAllQnAs() {
        return QnAServiceImpl.getAllQnAs();
    }

    @PostMapping
    public QnA createQnA(@RequestBody QnA qna) {
        return QnAServiceImpl.saveQnA(qna);
    }

    @DeleteMapping("/{id}")
    public void deleteQnA(@PathVariable Long id) {
        QnAServiceImpl.deleteQnA(id);
    }
}
