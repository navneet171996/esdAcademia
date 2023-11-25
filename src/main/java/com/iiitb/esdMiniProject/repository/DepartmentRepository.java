package com.iiitb.esdMiniProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.esdMiniProject.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
