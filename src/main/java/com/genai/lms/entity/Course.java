package com.genai.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    private List<Lesson> lessons;
}
