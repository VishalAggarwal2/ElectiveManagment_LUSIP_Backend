package com.ElectiveManagment.ElectiveManagment.controller;

import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enroll")
public class EnrollmentController {

    @Autowired
    EnrollmentService es;


    @PostMapping("/add")
    ResponseEntity<ApiSuccessMessgage> createEnrollment(@RequestParam int studentId , @RequestParam int  courseId ,@RequestParam(value = "",defaultValue = "FCFS") String type){
     return  es.createEnrollment(studentId,courseId,type);
    }

}


