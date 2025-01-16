package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Ashutosh",
                        22,
                        LocalDate.of(2002, Month.OCTOBER, 23),
                        "abc.gmail.com"
                )
        );
    }
}
