package com.ElectiveManagment.ElectiveManagment.service.Impl;

import com.ElectiveManagment.ElectiveManagment.entity.Course;
import com.ElectiveManagment.ElectiveManagment.entity.Faculty;
import com.ElectiveManagment.ElectiveManagment.entity.Students;
import com.ElectiveManagment.ElectiveManagment.exceptions.ResourceNotFoundException;
import com.ElectiveManagment.ElectiveManagment.repository.CourseRepository;
import com.ElectiveManagment.ElectiveManagment.repository.FacultyRepository;
import com.ElectiveManagment.ElectiveManagment.repository.StudentRepository;
import com.ElectiveManagment.ElectiveManagment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Course addCourse(int facultyId, Course course) throws ResourceNotFoundException {
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty not found with id " + facultyId));
        course.setFaculty(faculty);
        return courseRepository.save(course);
    }

    @Override
    public void enrollCourse(int studentId, Integer courseId) throws ResourceNotFoundException {
        Students student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));

        if(course.getStudents().size() >= course.getStudentLimit()){
            throw new IllegalStateException("Course limit reached. Cannot enroll more students.");
        }

        // Avoid duplicate enrollment
        if(student.getEnrolledCourses().contains(course)){
            throw new IllegalStateException("Student already enrolled in this course.");
        }

        student.getEnrolledCourses().add(course);
        course.getStudents().add(student);

        // Save updated entities
        studentRepository.save(student);
        courseRepository.save(course);
    }



    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCoursesByFaculty(int facultyId) throws ResourceNotFoundException {
        if (!facultyRepository.existsById(facultyId)) {
            throw new ResourceNotFoundException("Faculty not found with id " + facultyId);
        }
        return courseRepository.findByFacultyId(facultyId);
    }


    @Override
    public List<Course> getEnrolledCoursesByStudent(int studentId) throws ResourceNotFoundException {
        Students student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        return student.getEnrolledCourses();
    }
}