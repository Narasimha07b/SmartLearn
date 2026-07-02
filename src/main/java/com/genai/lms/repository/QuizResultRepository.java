package com.genai.lms.repository;

import com.genai.lms.entity.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

    long countByUserId(Long userId);

    List<QuizResult> findByUserId(Long userId);

}