package com.iiitb.esdMiniProject.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.esdMiniProject.entities.AddTa;
import com.iiitb.esdMiniProject.entities.Course;
import com.iiitb.esdMiniProject.entities.Faculty;
import com.iiitb.esdMiniProject.entities.Student;
import com.iiitb.esdMiniProject.repository.CourseRepository;
import com.iiitb.esdMiniProject.repository.FacultyRepository;
import com.iiitb.esdMiniProject.repository.StudentRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    
    public Integer addTaByFaculty(AddTa addTa){
        Optional<Faculty> fOptional = facultyRepository.findByFacCode(addTa.getFacultyCode());
        if(fOptional.isPresent()){
            fOptional.get().getCourses().forEach(course -> {
                if(course.getCourseCode().equals(addTa.getCourseCode())){
                    if(course.getTa().size() < course.getMaxTA()){
                        Optional<Student> sOptional = studentRepository.findByStudentRollNo(addTa.getTaRollNo());
                        if(sOptional.isPresent()){
                            Student student = sOptional.get();
                            course.getTa().add(student);
                            courseRepository.save(course);
                        }
                    }
                }
            });
        }
        return 1;
    }

    public Set<Course> viewCoursesByFaculty(String facCode){
        Optional<Faculty> fOptional = facultyRepository.findByFacCode(facCode);
        if(fOptional.isPresent()){
            Faculty faculty = fOptional.get();
            return faculty.getCourses();
        }
        return new HashSet<>();
    }
}
