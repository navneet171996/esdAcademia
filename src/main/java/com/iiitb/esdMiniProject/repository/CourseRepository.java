package com.iiitb.esdMiniProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.esdMiniProject.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
