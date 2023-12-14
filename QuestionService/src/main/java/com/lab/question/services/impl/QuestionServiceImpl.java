package com.lab.question.services.impl;

import com.lab.question.entities.Question;
import com.lab.question.repositories.QuestionRepository;
import com.lab.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    @Override
    public Question deleteOne(Long questionId) {
        Optional<Question> findOne = questionRepository.findById(questionId);
        questionRepository.deleteById(questionId);
         return findOne.orElseThrow(()->new RuntimeException("QuestionId not found"));
    }


}
