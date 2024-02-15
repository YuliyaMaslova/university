package com.example.university.service;

import com.example.university.entity.Faculty;
import com.example.university.model.FacultyGroupCountDTO;
import com.example.university.model.FacultyStudentCountDTO;
import com.example.university.repository.FacultyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
   private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }


    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(int id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public void deleteFaculty(int id) {
        facultyRepository.deleteById(id);
    }

    public Page<FacultyGroupCountDTO> getFacultyGroupCount(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return facultyRepository.findFacultyGroupCount(pageable);
    }

    public Page<FacultyStudentCountDTO> getFacultyStudentCount(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return facultyRepository.findFacultyStudentCount(pageable);
    }






}
