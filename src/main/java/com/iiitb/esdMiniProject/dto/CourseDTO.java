package com.iiitb.esdMiniProject.dto;

import java.util.Set;

import com.iiitb.esdMiniProject.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    
    private String courseCode;
    private String courseName;
    private Set<Student> ta;
}
