package com.ElectiveManagment.ElectiveManagment.entity;

import com.ElectiveManagment.ElectiveManagment.Enums.Department;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Faculties")
public class Faculty extends User {
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
    private Department dpt;
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();
}


