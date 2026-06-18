package com.genai.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    private Integer totalQuestions;

    private Double percentage;

    @ManyToOne
    private User user;

    @ManyToOne
    private Quiz quiz;
}