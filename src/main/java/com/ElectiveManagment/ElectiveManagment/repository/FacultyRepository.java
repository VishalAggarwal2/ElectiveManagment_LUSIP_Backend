package com.ElectiveManagment.ElectiveManagment.repository;

import com.ElectiveManagment.ElectiveManagment.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    Optional<Faculty> findByEmail(String email);
}