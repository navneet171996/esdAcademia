package com.iiitb.esdMiniProject.aux;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.esdMiniProject.entities.Course;
import com.iiitb.esdMiniProject.entities.Faculty;
import com.iiitb.esdMiniProject.entities.Specialization;
import com.iiitb.esdMiniProject.entities.Student;
import com.iiitb.esdMiniProject.repository.CourseRepository;
import com.iiitb.esdMiniProject.repository.FacultyRepository;
import com.iiitb.esdMiniProject.repository.StudentRepository;

@Service
public class AuxService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;
    
    public Student addStudent(AuxStudentDTO studentDTO){
        Student student = new Student();
        student.setStudentName(studentDTO.getName());
        student.setGender(studentDTO.getGender());
        student.setLoginId(studentDTO.getLoginId());
        student.setPassword(studentDTO.getPassword());

        return studentRepository.save(student);

    }

    public Faculty addFaculty(AuxFacultyDTO facultyDTO){
        Faculty faculty = new Faculty();
        faculty.setName(facultyDTO.getName());
        faculty.setEmail(facultyDTO.getEmail());
        faculty.setPassword(facultyDTO.getPassword());
        faculty.setFacCode(facultyDTO.getFacCode());

        return facultyRepository.save(faculty);
    }

    public Course addCourse(AuxCourseDTO courseDTO){
        Course course = new Course();
        course.setCourseCode(courseDTO.getCourseCode());
        course.setCourseName(courseDTO.getCourseName());
        course.setCredit(courseDTO.getCredit());
        switch (courseDTO.getSpecialization()) {
            case 1:
                course.setSpecialization(Specialization.THEORY_AND_SYSTEMS);
                break;
            case 2:
                course.setSpecialization(Specialization.MACHINE_LEARNING);
                break;
            case 3:
                course.setSpecialization(Specialization.NETWORKING);
            default:
                break;
        }
        course.setSpecialization(Specialization.MACHINE_LEARNING);
        course.setMaxStudents(courseDTO.getMaxStudents());
        course.setMaxTA(courseDTO.getMaxTa());
        Optional<Faculty> facOption = facultyRepository.findByFacCode(courseDTO.getFacId());
        if(facOption.isPresent()){
            course.setFaculty(facOption.get());
        }else{
            course.setFaculty(null);
        }

        return courseRepository.save(course);
    }
}
