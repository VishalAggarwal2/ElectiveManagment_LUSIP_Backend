package com.ElectiveManagment.ElectiveManagment.entity;

import com.ElectiveManagment.ElectiveManagment.Enums.Branch;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Students")
public class Students extends User {
    private float cgpa;
    private  String RollNumber;
    private Branch branch;
}
