package com.example.university.controller;

import com.example.university.entity.Faculty;
import com.example.university.model.FacultyGroupCountDTO;
import com.example.university.model.FacultyStudentCountDTO;
import com.example.university.service.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("/faculties")
    public List<Faculty> showAllFaculties() {
        List<Faculty> allFaculties = facultyService.getAllFaculty();
        return allFaculties;
    }

    @GetMapping("/faculties/{id}")
    public Faculty getFaculty(@PathVariable int id) {
        Faculty faculty = facultyService.getFaculty(id);
        return faculty;
    }

    @PostMapping("/faculties")
    public Faculty createNewFaculties(@RequestBody Faculty faculty) {
        return facultyService.saveFaculty(faculty);
    }

    @PutMapping("/faculties")
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.saveFaculty(faculty);
    }

    @DeleteMapping("/faculties/{id}")
    public String deleteFaculty(@PathVariable int id) {
        facultyService.deleteFaculty(id);
        return "Faculty with ID = " + id + " was deleted";
    }

    @GetMapping("/group-count")
    public Page<FacultyGroupCountDTO> getFacultyGroupCount(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size) {
        return facultyService.getFacultyGroupCount(page, size);
    }

    @GetMapping("/student-count")
    public Page<FacultyStudentCountDTO> getFacultyStudentCount(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) {
        return facultyService.getFacultyStudentCount(page, size);
    }



}
