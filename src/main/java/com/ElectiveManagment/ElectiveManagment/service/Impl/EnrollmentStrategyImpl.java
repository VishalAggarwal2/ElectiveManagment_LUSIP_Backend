package com.ElectiveManagment.ElectiveManagment.service.Impl;

import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.entity.Enrollment;
import com.ElectiveManagment.ElectiveManagment.service.EnrollmentService;
import com.ElectiveManagment.ElectiveManagment.service.Factory.EnrollmentStrategyFactory;
import com.ElectiveManagment.ElectiveManagment.service.Strategy.EnrollCourseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentStrategyImpl implements EnrollmentService {
    @Autowired
    EnrollmentStrategyFactory ef;

    @Override
    public ResponseEntity<ApiSuccessMessgage> createEnrollment(int courseId, int studentId, String type) {
       Enrollment e = ef.enrollFactory(type).enrollStudent(courseId,studentId);
       ApiSuccessMessgage<Enrollment> message = new ApiSuccessMessgage<>();
       message.setMessage("Student Enrolled In The Course Succc ..");
       message.setBody(e);
       message.setSuccess(true);
       return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
