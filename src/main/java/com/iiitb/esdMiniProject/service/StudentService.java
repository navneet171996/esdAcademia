package com.iiitb.esdMiniProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.esdMiniProject.entities.Student;
import com.iiitb.esdMiniProject.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Optional<?> fetchStudent(Long id){
        return repository.findById(id);
    }

    public void addStudent(Student student){
        repository.save(student);
    }
    
}
