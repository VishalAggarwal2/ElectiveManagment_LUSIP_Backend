package com.ElectiveManagment.ElectiveManagment.repository;

import com.ElectiveManagment.ElectiveManagment.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
}
