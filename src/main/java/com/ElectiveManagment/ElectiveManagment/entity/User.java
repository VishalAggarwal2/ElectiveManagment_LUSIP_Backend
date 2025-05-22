package com.ElectiveManagment.ElectiveManagment.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Users")
public abstract class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String FirstName;
private String LastName;
private String Email;
private String Password;
private String Number;
}
