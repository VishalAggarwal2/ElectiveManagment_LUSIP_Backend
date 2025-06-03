package com.ElectiveManagment.ElectiveManagment.service;


import com.ElectiveManagment.ElectiveManagment.entity.Course;
import com.ElectiveManagment.ElectiveManagment.exceptions.ResourceNotFoundException;

import java.util.List;

public interface CourseService {

    Course addCourse(int facultyId, Course course) ;

    void enrollCourse(int studentId, Integer courseId) ;

    List<Course> getAllCourses();

    List<Course> getCoursesByFaculty(Long facultyId) ;

    List<Course> getEnrolledCoursesByStudent(Long studentId) ;
}
