package com.ElectiveManagment.ElectiveManagment.service;

import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.entity.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {
    ResponseEntity<ApiSuccessMessgage> addCourse(int facultyId, Course c);
    ResponseEntity<ApiSuccessMessgage> viewMyOfferedCourse(int facultyId);
    ResponseEntity<ApiSuccessMessgage> viewMyEnrolledCourse(int studentId);
    ResponseEntity<ApiSuccessMessgage> viewAllAvailableCourse();
}
