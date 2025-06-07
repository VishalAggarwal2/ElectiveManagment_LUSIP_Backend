package com.ElectiveManagment.ElectiveManagment.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String courseName;
    private String courseDesc;

    public int getGpaLimit() {
        return gpaLimit;
    }

    public void setGpaLimit(int gpaLimit) {
        this.gpaLimit = gpaLimit;
    }

    private int StudentLimit;
    private int gpaLimit;

    public int getStudentEnrolledCount() {
        return studentEnrolledCount;
    }

    public void setStudentEnrolledCount(int studentEnrolledCount) {
        this.studentEnrolledCount = studentEnrolledCount;
    }

    private int studentEnrolledCount;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Version
    private int version;



    @ManyToMany
    @JoinTable(
            name = "faculty_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private List<Faculty> facultyList = new ArrayList<>();

    @ManyToMany(mappedBy = "enrolledCourses")
    private List<Students> students = new ArrayList<>();





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

    public int getStudentLimit() {
        return StudentLimit;
    }

    public void setStudentLimit(int studentLimit) {
        StudentLimit = studentLimit;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
