package com.iiitb.esdMiniProject.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iiitb.esdMiniProject.entities.Course;
import com.iiitb.esdMiniProject.entities.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    
    Optional<Faculty> findByEmail(String email);

    Optional<Faculty> findByFacCode(String facCode);

    @Query("SELECT c FROM Course c WHERE c.faculty.facCode = :facCode")
    Optional<Set<Course>> findCoursesByFaculty(String facCode);
}
