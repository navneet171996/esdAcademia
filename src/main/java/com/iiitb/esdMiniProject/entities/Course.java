package com.iiitb.esdMiniProject.entities;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course_Id")
    private Long courseId;

    @Column(name = "Course_Code")
    private String courseCode;

    @Column(name = "Course_Name")
    private String courseName;

    private Specialization specialization;

    @Column(name = "Credits")
    private Integer credit;

    @ManyToOne
    @JoinColumn(name = "Faculty_id", referencedColumnName = "faculty_id")
    private Faculty faculty;

    @ManyToMany
    @JoinTable(name = "Course_TA", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "Course_Id"), inverseJoinColumns = @JoinColumn(name = "ta_id", referencedColumnName = "student_id"))
    private Set<Student> ta = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "Course_Id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
    private Set<Student> students = new HashSet<>();

    @Column(name = "max_students")
    private Integer maxStudents;

    @Column(name = "max_ta")
    private Integer maxTA;

    
}
