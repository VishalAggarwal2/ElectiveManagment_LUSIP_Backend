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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public List<com.ElectiveManagment.ElectiveManagment.entity.Faculty> getFaculty() {
        return Faculty;
    }

    public void setFaculty(List<Faculty> faculty) {
        Faculty = faculty;
    }

    public int getStudentLimit() {
        return StudentLimit;
    }

    public void setStudentLimit(int studentLimit) {
        StudentLimit = studentLimit;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    private  String course;
    @OneToMany
    private List<Faculty> Faculty;
    private int StudentLimit;
    @OneToMany
    private List<Students> students;
}
