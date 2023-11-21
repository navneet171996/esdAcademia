package com.iiitb.esdMiniProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.esdMiniProject.entities.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    
    Optional<Faculty> findByEmail(String email);
}
