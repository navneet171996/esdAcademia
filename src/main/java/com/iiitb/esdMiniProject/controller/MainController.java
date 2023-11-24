package com.iiitb.esdMiniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.esdMiniProject.entities.AddTa;
import com.iiitb.esdMiniProject.entities.AuthenticationObject;
import com.iiitb.esdMiniProject.service.AuthenticationService;
import com.iiitb.esdMiniProject.service.FacultyService;

@RestController
@RequestMapping(path = "/api/home")
public class MainController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationObject credentials){
        if(authenticationService.authenticate(credentials)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addTa")
    public ResponseEntity<?> addTaByFaculty(@RequestBody AddTa addTa){
        Integer response = facultyService.addTaByFaculty(addTa);
        if(response == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    
}
