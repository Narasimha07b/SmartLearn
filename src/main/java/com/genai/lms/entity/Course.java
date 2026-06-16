package com.genai.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String instructor;

    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL)
    private List<Lesson> lessons;
}
