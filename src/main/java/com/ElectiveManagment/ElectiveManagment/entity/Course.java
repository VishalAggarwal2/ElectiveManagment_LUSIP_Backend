package com.ElectiveManagment.ElectiveManagment.entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String courseName;
    private  String courseDesc;
    private  String course;
    @OneToMany
    private List<Faculty> Faculty;
    private int StudentLimit;
    @OneToMany
    private List<Students> students;
}
