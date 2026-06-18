package com.genai.lms.dto;

import lombok.Data;

@Data
public class AnswerRequest {

    private Long questionId;

    private String answer;
}