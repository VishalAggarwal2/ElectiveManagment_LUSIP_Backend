package com.ElectiveManagment.ElectiveManagment.entity;

import com.ElectiveManagment.ElectiveManagment.Enums.Department;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Faculties")
public class Faculty extends User {
    private Department dpt;
}
