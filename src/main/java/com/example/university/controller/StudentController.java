package com.example.university.controller;

import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/students")
    public List<Student> showAllStudents() {
        List<Student> allStudent = studentService.getAllStudent();
        return allStudent ;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        return student;
    }

    @PostMapping("/students")
    public Student createNewStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student this ID = " + id + " was deleted";

    }


}
