package com.example.university.repository;

import com.example.university.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT f.id as faculty_id, f.name as faculty_name, COUNT(s.id) as student_count " +
            "FROM Faculty f " +
            "LEFT JOIN f.groups g " +
            "LEFT JOIN g.students s " +
            "GROUP BY f.id, f.name")
    Page<Object[]> findFacultyStudentCount(Pageable pageable);


}
