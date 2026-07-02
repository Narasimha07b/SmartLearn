package com.genai.lms.dto;

import lombok.Data;

@Data
public class StudentDashboardResponse {

    private String studentName;

    private String email;

    private long enrolledCourses;

    private long completedQuizzes;

    private double averageScore;
}