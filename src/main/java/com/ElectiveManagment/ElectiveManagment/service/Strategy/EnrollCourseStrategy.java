package com.ElectiveManagment.ElectiveManagment.service.Strategy;

import com.ElectiveManagment.ElectiveManagment.entity.Enrollment;

public interface EnrollCourseStrategy {
    Enrollment enrollStudent(int courseId,int studentId);
}
