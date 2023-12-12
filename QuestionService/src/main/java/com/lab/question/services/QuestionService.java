package com.lab.question.services;

import com.lab.question.entities.Question;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {
    Question add(Question question);

    List<Question> get();

    Question get(Long questionId);

    List<Question> getByQuizId(Long quizId);
}
