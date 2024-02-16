package com.example.university.repository;

import com.example.university.entity.Student;
import com.example.university.model.StudentDTO;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT new com.example.university.model.StudentDTO(s.id, s.name) " +
            "FROM Student s " +
            "INNER JOIN s.groups g " +
            "GROUP BY s.id, s.name " +
            "HAVING COUNT(DISTINCT g.id) > 1")
    List<StudentDTO> findStudentsInMultipleGroups();


}
