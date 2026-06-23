package com.genai.lms.service;

import com.genai.lms.dto.AnswerRequest;
import com.genai.lms.dto.QuizSubmissionRequest;
import com.genai.lms.entity.Question;
import com.genai.lms.repository.QuestionRepository;
import com.genai.lms.repository.QuizRepository;
import com.genai.lms.repository.QuizResultRepository;
import com.genai.lms.repository.UserRepository;
import com.genai.lms.entity.QuizResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizResultService {

    @Autowired
    private QuizResultRepository quizResultRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public QuizResult submitQuiz(
            QuizSubmissionRequest request) {

        int score = 0;

        List<Question> questions =
                questionRepository.findByQuizId(
                        request.getQuizId());

        for (AnswerRequest answer :
                request.getAnswers()) {

            Question question =
                    questionRepository.findById(
                                    answer.getQuestionId())
                            .orElseThrow();

            if (question.getCorrectAnswer()
                    .equalsIgnoreCase(
                            answer.getAnswer())) {

                score++;
            }
        }

        QuizResult result = new QuizResult();

        int totalQuestions =
                request.getAnswers().size();

        result.setTotalQuestions(
                totalQuestions);

        result.setPercentage(
                (score * 100.0)
                        / totalQuestions);

        result.setUser(
                userRepository.findById(
                                request.getUserId())
                        .orElseThrow());

        result.setQuiz(
                quizRepository.findById(
                                request.getQuizId())
                        .orElseThrow());

        return quizResultRepository.save(result);
    }
}