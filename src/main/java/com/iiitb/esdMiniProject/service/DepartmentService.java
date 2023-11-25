package com.iiitb.esdMiniProject.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.esdMiniProject.entities.Department;
import com.iiitb.esdMiniProject.entities.Employee;
import com.iiitb.esdMiniProject.repository.DepartmentRepository;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> viewAllDepartments(){
        return departmentRepository.findAll();
    }

    public Set<Employee> viewAllEmpByDept(Long deptId){
        Optional<Department> opDept = departmentRepository.findById(deptId);
        if(opDept.isPresent()){
            return opDept.get().getEmployees();
        }
        return new HashSet<>();
    }
}
