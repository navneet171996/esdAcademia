package com.iiitb.esdMiniProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.esdMiniProject.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
    Optional<Course> findByCourseCode(String courseCode);
}
