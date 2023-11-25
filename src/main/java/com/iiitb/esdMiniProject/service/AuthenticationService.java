package com.iiitb.esdMiniProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.esdMiniProject.entities.Admin;
import com.iiitb.esdMiniProject.entities.AuthenticationObject;
import com.iiitb.esdMiniProject.entities.Faculty;
import com.iiitb.esdMiniProject.entities.Student;
import com.iiitb.esdMiniProject.repository.AdminRepository;
import com.iiitb.esdMiniProject.repository.FacultyRepository;
import com.iiitb.esdMiniProject.repository.StudentRepository;

@Service
public class AuthenticationService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    private boolean authenticateStudent(String username, String password){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(username);
        if(studentByEmail.isPresent()){
            Student student = studentByEmail.get();
            return password.equals(student.getPassword());
            
        }else{
            return false;
        }
    }

    private boolean authenticateAdmin(String username, String password){
        Optional<Admin> adminByEmail = adminRepository.findByUsername(username);
        if(adminByEmail.isPresent()){
            Admin admin = adminByEmail.get();
            return password.equals(admin.getPassword());
            
        }else{
            return false;
        }
    }

    private boolean authenticateFaculty(String username, String password){
        Optional<Faculty> facultyByEmail = facultyRepository.findByFacCode(username);
        if(facultyByEmail.isPresent()){
            Faculty faculty = facultyByEmail.get();
            return password.equals(faculty.getPassword());
            
        }else{
            return false;
        }
    }

    public boolean authenticate(AuthenticationObject authenticationObject){
        if(authenticationObject.getMode() == 0)
            return authenticateAdmin(authenticationObject.getUsername(), authenticationObject.getPassword());
        else if(authenticationObject.getMode() == 1)
            return authenticateFaculty(authenticationObject.getUsername(), authenticationObject.getPassword());
        else
            return authenticateStudent(authenticationObject.getUsername(), authenticationObject.getPassword());
    }
}
