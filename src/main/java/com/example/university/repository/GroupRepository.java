package com.example.university.repository;

import com.example.university.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("SELECT f.id as faculty_id, f.name as faculty_name, COUNT(g.id) as group_count " +
            "FROM Faculty f " +
            "LEFT JOIN f.groups g " +
            "GROUP BY f.id, f.name")
    Page<Object[]> findFacultyGroupCount(Pageable pageable);


}
