package com.example.university.repository;

import com.example.university.entity.Faculty;
import com.example.university.model.FacultyGroupCountDTO;
import com.example.university.model.FacultyStudentCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Query("SELECT f.id as faculty_id, f.name as faculty_name, COUNT(g.id) as group_count " +
            "FROM Faculty f " +
            "LEFT JOIN f.groups g " +
            "GROUP BY f.id, f.name")
    Page<FacultyGroupCountDTO> findFacultyGroupCount(Pageable pageable);

    @Query("SELECT f.id as faculty_id, f.name as faculty_name, COUNT(s.id) as student_count " +
            "FROM Faculty f " +
            "LEFT JOIN f.groups g " +
            "LEFT JOIN g.students s " +
            "GROUP BY f.id, f.name")
    Page<FacultyStudentCountDTO> findFacultyStudentCount(Pageable pageable);


}
