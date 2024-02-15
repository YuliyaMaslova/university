package com.example.university.model;

import lombok.Data;

@Data
public class FacultyStudentCountDTO {
    private int facultyId;
    private String facultyName;
    private int studentCount;
}
