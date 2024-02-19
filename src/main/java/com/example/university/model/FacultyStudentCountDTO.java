package com.example.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FacultyStudentCountDTO {
    private int facultyId;
    private String facultyName;
    private Long studentCount;
}
