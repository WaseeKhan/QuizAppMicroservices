package com.lab.question.services.impl;

import com.lab.question.entities.Question;
import com.lab.question.repositories.QuestionRepository;
import com.lab.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    public void deleteQuestion(Long questionId) {
        questionRepository.findById(questionId).orElseThrow(()->new RuntimeException("Question Id not found for Delete"));
        questionRepository.deleteById(questionId);
    }

    @Override
    public Question updateQuestion(Question question, Long questionId) {
        Question questionIdForUpdate = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question no found for update"));
        questionIdForUpdate.setQuestion(question.getQuestion());
        return questionIdForUpdate;
    }
}
