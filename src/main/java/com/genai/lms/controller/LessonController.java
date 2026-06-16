package com.genai.lms.controller;

import com.genai.lms.entity.Lesson;
import com.genai.lms.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson){
        return lessonService.createLesson(lesson);
    }

    @GetMapping
    public List<Lesson> getAllLessons(){
        return lessonService.getAllLessons();
    }
}
