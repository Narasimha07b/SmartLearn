package com.genai.lms.service;

import com.genai.lms.entity.Lesson;
import com.genai.lms.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public Lesson createLesson(Lesson lesson){
        return lessonRepository.save(lesson);
    }
    public List<Lesson> getAllLessons(){
        return lessonRepository.findAll();
    }
}
