package com.example.university.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "`group`")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_group"
            , joinColumns = @JoinColumn(name = "group_id")
            , inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

}
