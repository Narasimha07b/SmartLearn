package com.genai.lms.controller;

import com.genai.lms.dto.StudentDashboardResponse;
import com.genai.lms.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/student/{userId}")
    public StudentDashboardResponse getStudentDashboard(
            @PathVariable Long userId) {

        return dashboardService.getStudentDashboard(userId);
    }
}