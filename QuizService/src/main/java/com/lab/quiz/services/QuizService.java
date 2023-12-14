package com.lab.quiz.services;

import com.lab.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz get(Long id);

    void deleteQuiz(Long quizId);

    Quiz updateQuiz(Quiz quiz);
}
