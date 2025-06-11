package com.ElectiveManagment.ElectiveManagment.repository;


import com.ElectiveManagment.ElectiveManagment.entity.Course;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Optional<Course> findByCourseName(String Name);
//    // Vishal:- This Is Just Used WHen We Want no conflict
   @Lock(LockModeType.PESSIMISTIC_WRITE)
   @Query("SELECT c FROM Course c WHERE c.id = :id")
   Optional<Course> findByIdForUpdate(@Param("id") int id);
}
