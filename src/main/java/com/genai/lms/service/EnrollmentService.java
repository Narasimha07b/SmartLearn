package com.genai.lms.service;

import com.genai.lms.entity.Enrollment;
import com.genai.lms.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment createEnrollment(Enrollment enrollment){
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepository.findAll();
    }
    public Enrollment getEnrollmentById(Long id) {

        return enrollmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Enrollment not found"));
    }
    public String deleteEnrollment(Long id) {

        enrollmentRepository.deleteById(id);

        return "Enrollment Deleted Successfully";
    }
}
