package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/post")
    public void addStudent(@RequestBody Student student){
        studentService.addNewStudent(student);

    }

    @DeleteMapping("{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentID){
        studentService.deleteStudentByID(studentID);
    }


}
