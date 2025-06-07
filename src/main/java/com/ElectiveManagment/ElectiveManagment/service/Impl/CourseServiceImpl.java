package com.ElectiveManagment.ElectiveManagment.service.Impl;

import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.entity.Course;
import com.ElectiveManagment.ElectiveManagment.entity.Faculty;
import com.ElectiveManagment.ElectiveManagment.entity.Students;
import com.ElectiveManagment.ElectiveManagment.exceptions.ResourceNotFoundException;
import com.ElectiveManagment.ElectiveManagment.repository.CourseRepository;
import com.ElectiveManagment.ElectiveManagment.repository.FacultyRepository;
import com.ElectiveManagment.ElectiveManagment.repository.StudentRepository;
import com.ElectiveManagment.ElectiveManagment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl  implements CourseService {

    @Autowired
    CourseRepository cr;

    @Autowired
    FacultyRepository fr;

    @Autowired
    StudentRepository sr;

    @Override
    public ResponseEntity<ApiSuccessMessgage> addCourse(int facultyId, Course c) {


        String CourseName = c.getCourseName();

        return null;


    }



    @Override
    public ResponseEntity<ApiSuccessMessgage> viewMyOfferedCourse(int facultyId) {
        Optional<Faculty> faculty = fr.findById(facultyId);

        if(faculty.isEmpty()){
            throw new ResourceNotFoundException("Faculty Not Exist");
        }

        List<Course> allMyCoursed = faculty.get().getCourses();
        ApiSuccessMessgage<List<Course>> apiResponse = new ApiSuccessMessgage<>();
        apiResponse.setBody(allMyCoursed);
        apiResponse.setMessage("All My Offered Course");
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ApiSuccessMessgage> viewMyEnrolledCourse(int studentId) {
        Optional<Students> faculty = sr.findById(studentId);

        if(faculty.isEmpty()){
            throw new ResourceNotFoundException("Student Not Exist");
        }

        List<Course> allMyCoursed = faculty.get().getEnrolledCourses();
        ApiSuccessMessgage<List<Course>> apiResponse = new ApiSuccessMessgage<>();
        apiResponse.setBody(allMyCoursed);
        apiResponse.setMessage("All My Enrolled Course Course");
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiSuccessMessgage> viewAllAvailableCourse() {
    List<Course> c = cr.findAll();
    ApiSuccessMessgage<List<Course>> apiResponse = new ApiSuccessMessgage<>();
        apiResponse.setBody(c);
        apiResponse.setMessage("All  Course ");
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

