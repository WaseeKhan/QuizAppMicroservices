package com.lab.quiz.services.impl;

import com.lab.quiz.client.QuestionClient;
import com.lab.quiz.entities.Quiz;
import com.lab.quiz.repositries.QuizRepository;
import com.lab.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionClient questionClient;
    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
         List<Quiz> quizzes = quizRepository.findAll();
         List<Quiz> newQuizList = quizzes.stream().map((quiz) -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()));
        return quiz;
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.findById(quizId).orElseThrow(()->new RuntimeException("Quiz not forund for deletion!"));
        quizRepository.deleteById(quizId);

    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        Quiz existingQuiz = quizRepository.findById(quiz.getQuizId()).get();
        existingQuiz.setQuizTitle(quiz.getQuizTitle());
        Quiz updateQuiz = quizRepository.save(existingQuiz);
        return updateQuiz;
    }


}
