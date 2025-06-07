package com.ElectiveManagment.ElectiveManagment.repository;


import com.ElectiveManagment.ElectiveManagment.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Optional<Course> findByCourseName(String Name);
}
