package com.example.university.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "faculty")
public class Faculty {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;

     @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Group> groups;

}
