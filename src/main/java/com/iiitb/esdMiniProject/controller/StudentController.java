package com.iiitb.esdMiniProject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iiitb.esdMiniProject.entities.Student;
import com.iiitb.esdMiniProject.service.StudentService;

@Controller
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<?>> getStudentFromId(@PathVariable("id") Long id){
        Optional<?> student = studentService.fetchStudent(id);
        if(student !=null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> addStudent(Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
