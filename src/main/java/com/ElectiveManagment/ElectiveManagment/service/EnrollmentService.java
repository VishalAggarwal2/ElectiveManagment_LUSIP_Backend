package com.ElectiveManagment.ElectiveManagment.service;


import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import org.springframework.http.ResponseEntity;
public interface EnrollmentService {
    ResponseEntity<ApiSuccessMessgage> createEnrollment(int courseId,int studentId ,String type);
}
