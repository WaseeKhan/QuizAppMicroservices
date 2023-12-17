package com.lab.question.services;

import com.lab.question.entities.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question question);

    List<Question> get();

    Question get(Long questionId);

    List<Question> getByQuizId(Long quizId);

     void deleteQuestion(Long questionId);

     Question updateQuestion(Question question, Long questionId);


}
