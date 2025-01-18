package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){

        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentEmail.isPresent()){
            throw new IllegalStateException("email already present");
        }
        studentRepository.save(student);
    }

    public void deleteStudentByID(Long studentID) {

        boolean exists = studentRepository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException("id not present");
        }
        studentRepository.deleteById(studentID);
    }
}
