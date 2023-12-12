package com.lab.question.controllers;

import com.lab.question.entities.Question;
import com.lab.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.add(question);
    }

    @GetMapping
    public List<Question> get(){
        return questionService.get();
    }
    @GetMapping("/{questionId}")
    public Question get(@PathVariable Long questionId){
        return questionService.get(questionId);
    }
    @GetMapping("/quiz/{quizId}")
    public List<Question> getByQuizId(@PathVariable Long quizId){
        return questionService.getByQuizId(quizId);
    }
}
