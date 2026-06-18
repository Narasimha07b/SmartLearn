package com.genai.lms.controller;

import com.genai.lms.entity.Question;
import com.genai.lms.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question createQuestion(
            @RequestBody Question question) {

        return questionService.createQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(
            @PathVariable Long id) {

        return questionService.getQuestionById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(
            @PathVariable Long id) {

        return questionService.deleteQuestion(id);
    }
}