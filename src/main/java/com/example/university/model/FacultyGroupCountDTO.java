package com.example.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FacultyGroupCountDTO {
    private Integer facultyId;
    private String facultyName;
    private Long groupCount;

}
