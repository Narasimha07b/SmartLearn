package com.genai.lms.controller;

import com.genai.lms.dto.QuizSubmissionRequest;
import com.genai.lms.entity.Quiz;
import com.genai.lms.entity.QuizResult;
import com.genai.lms.service.QuizResultService;
import com.genai.lms.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {

        System.out.println(quiz);

        return quizService.createQuiz(quiz);
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {

        return quizService.getAllQuizzes();
    }

    @Autowired
    private QuizResultService quizResultService;

    @PostMapping("/submit")
    public QuizResult submitQuiz(
            @RequestBody QuizSubmissionRequest request) {

        return quizResultService.submitQuiz(request);
    }
}