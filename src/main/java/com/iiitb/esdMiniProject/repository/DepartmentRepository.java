package com.iiitb.esdMiniProject.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iiitb.esdMiniProject.entities.Department;
import com.iiitb.esdMiniProject.entities.Employee;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

    @Query("SELECT e FROM Employee e WHERE e.department.deptId = :deptId")
    Optional<Set<Employee>> findEmployeesByDept(Long deptId);
}
