package com.ElectiveManagment.ElectiveManagment.controller;

import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.dto.LoginRequest;
import com.ElectiveManagment.ElectiveManagment.dto.SignupRequest;
import com.ElectiveManagment.ElectiveManagment.entity.Course;
import com.ElectiveManagment.ElectiveManagment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService cs;

    @GetMapping("/allMyOfferedCourse")
    public ResponseEntity<ApiSuccessMessgage> getMyOfferedCourse(@RequestParam int FacultyId) {
        return cs.viewMyOfferedCourse(FacultyId);
    }

    @GetMapping("/allMyEnrolledCourse")
    public ResponseEntity<ApiSuccessMessgage> getMyEnrolledCourse(@RequestParam int studentId) {
        return cs.viewMyEnrolledCourse(studentId);
    }

    @GetMapping("/allCourses")
    public ResponseEntity<ApiSuccessMessgage> getAllCourses() {
        return cs.viewAllAvailableCourse();
    }
}
