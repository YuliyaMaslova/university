package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.model.StudentDTO;
import com.example.university.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public List<StudentDTO> getStudentsInMultipleGroups() {
        return studentRepository.findStudentsInMultipleGroups();
    }

    public List<StudentDTO> getStudentsInMoreGroups() {
        return studentRepository.findStudentByMoreGroups().stream()
                .map(s -> new StudentDTO(s.getId(), s.getName()))
                .toList();
    }


}
