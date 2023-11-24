package com.iiitb.esdMiniProject.entities;




import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Student")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "student_rollNo")
    private String studentRollNo;
    
    @Column(name = "name")
    private String studentName;

    @Column(name = "gender")
    private char gender;

    @Column(name = "login")
    private String loginId;

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private Set<Course> coursesTaken = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "ta")
    private Set<Course> courseTa = new HashSet<>();
}