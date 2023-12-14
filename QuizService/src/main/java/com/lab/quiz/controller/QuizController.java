package com.lab.quiz.controller;

import com.lab.quiz.entities.Quiz;
import com.lab.quiz.services.QuizService;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;


    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> get(){
        return quizService.get();
    }
@GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id){
        return quizService.get(id);
    }

    @DeleteMapping("/{quizId}")
    public String deleteQuiz(@PathVariable Long quizId){
        quizService.deleteQuiz(quizId);
        return "Quiz Deleted Successfully!!";
    }


    @PutMapping("/{quizId}")
    public Quiz updateQuiz(@RequestBody Quiz quiz, @PathVariable Long quizId){
        quiz.setQuizId(quizId);
        Quiz updatedQuiz = quizService.updateQuiz(quiz);
        return updatedQuiz;
    }

}
