package com.iiitb.esdMiniProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iiitb.esdMiniProject.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.loginId = :email")
    Optional<Student> findStudentByEmail(String email);

    Optional<Student> findByLoginId(String loginId);
    
}
