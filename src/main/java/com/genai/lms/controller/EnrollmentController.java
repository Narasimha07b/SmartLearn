package com.genai.lms.controller;

import com.genai.lms.entity.Enrollment;
import com.genai.lms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment){
        return enrollmentService.createEnrollment(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable long id){
        return enrollmentService.getEnrollmentById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEnrollmentById(@PathVariable long id){
        enrollmentService.deleteEnrollment(id);
        return true;
    }
}
