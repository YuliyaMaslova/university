package com.example.university.repository;

import com.example.university.entity.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {


}
