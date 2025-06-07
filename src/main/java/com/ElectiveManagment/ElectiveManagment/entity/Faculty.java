package com.ElectiveManagment.ElectiveManagment.entity;

import com.ElectiveManagment.ElectiveManagment.Enums.Department;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Faculties")
public class Faculty extends User {
    private Department dpt;
    @ManyToMany(mappedBy = "facultyList",fetch = FetchType.EAGER)
    private List<Course> courses = new ArrayList<>();
    public Department getDpt() {
        return dpt;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public void setDpt(Department dpt) {
        this.dpt = dpt;
    }

}


