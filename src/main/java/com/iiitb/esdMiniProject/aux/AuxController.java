package com.iiitb.esdMiniProject.aux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/aux")
public class AuxController {

    @Autowired
    private AuxService auxService;

    @PostMapping(path = "/add/student")
    public ResponseEntity<?> addStudent(@RequestBody AuxStudentDTO studentDTO){
        auxService.addStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/add/faculty")
    public ResponseEntity<?> addFaculty(@RequestBody AuxFacultyDTO facultyDTO){
        auxService.addFaculty(facultyDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(path = "/add/course")
    public ResponseEntity<?> addCourse(@RequestBody AuxCourseDTO courseDTO){
        auxService.addCourse(courseDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/add/department")
    public ResponseEntity<?> addDept(@RequestBody AuxDeptDTO deptDTO){
        auxService.addDept(deptDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/add/employee")
    public ResponseEntity<?> addEmployee(@RequestBody AuxEmployeeDTO employeeDTO){
        auxService.addEmployee(employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
