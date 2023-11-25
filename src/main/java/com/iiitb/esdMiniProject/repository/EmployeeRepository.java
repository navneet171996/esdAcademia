package com.iiitb.esdMiniProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.esdMiniProject.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
