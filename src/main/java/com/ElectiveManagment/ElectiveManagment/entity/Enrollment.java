package com.ElectiveManagment.ElectiveManagment.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Course course;
    @OneToOne
    private Students student;
    @CreationTimestamp
    private LocalDateTime timeStamp;
}
