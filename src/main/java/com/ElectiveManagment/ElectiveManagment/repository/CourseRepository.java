package com.ElectiveManagment.ElectiveManagment.repository;

import com.ElectiveManagment.ElectiveManagment.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByFacultyId(int facultyId);
}