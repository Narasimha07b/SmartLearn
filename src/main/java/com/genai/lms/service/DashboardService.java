package com.genai.lms.service;

import com.genai.lms.dto.StudentDashboardResponse;
import com.genai.lms.entity.QuizResult;
import com.genai.lms.entity.User;
import com.genai.lms.repository.EnrollmentRepository;
import com.genai.lms.repository.QuizResultRepository;
import com.genai.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private QuizResultRepository quizResultRepository;

    public StudentDashboardResponse getStudentDashboard(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        StudentDashboardResponse response = new StudentDashboardResponse();

        response.setStudentName(user.getName());
        response.setEmail(user.getEmail());

        response.setEnrolledCourses(
                enrollmentRepository.countByUserId(userId));

        response.setCompletedQuizzes(
                quizResultRepository.countByUserId(userId));

        List<QuizResult> results =
                quizResultRepository.findByUserId(userId);

        double total = 0;

        for (QuizResult result : results) {
            total += result.getPercentage();
        }

        if (!results.isEmpty()) {
            response.setAverageScore(
                    total / results.size());
        }

        return response;
    }
}