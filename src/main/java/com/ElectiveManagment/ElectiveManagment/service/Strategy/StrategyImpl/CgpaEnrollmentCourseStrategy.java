package com.ElectiveManagment.ElectiveManagment.service.Strategy.StrategyImpl;

import com.ElectiveManagment.ElectiveManagment.entity.Course;
import com.ElectiveManagment.ElectiveManagment.entity.Enrollment;
import com.ElectiveManagment.ElectiveManagment.entity.Students;
import com.ElectiveManagment.ElectiveManagment.exceptions.ConditionNotMeetException;
import com.ElectiveManagment.ElectiveManagment.exceptions.ResourceLimitFullException;
import com.ElectiveManagment.ElectiveManagment.exceptions.ResourceNotFoundException;
import com.ElectiveManagment.ElectiveManagment.repository.CourseRepository;
import com.ElectiveManagment.ElectiveManagment.repository.EnrollmentRepository;
import com.ElectiveManagment.ElectiveManagment.repository.StudentRepository;
import com.ElectiveManagment.ElectiveManagment.service.Strategy.EnrollCourseStrategy;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CgpaEnrollmentCourseStrategy implements EnrollCourseStrategy {

    @Autowired
    CourseRepository cr;

    @Autowired
    StudentRepository sr;

    @Autowired
    EnrollmentRepository er;


    @Transactional
    @Override
    public Enrollment enrollStudent(int courseId, int studentId) {
        for (int i = 0; i < 3; i++) { // Retry 3 times in case of version conflict
            try {
                Course course = cr.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course Not Found"));
                Students student = sr.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student Not Found"));

                if (student.getCgpa() < course.getGpaLimit()) {
                    throw new ConditionNotMeetException("CGPA is less than required");
                }

                if (course.getStudentEnrolledCount() >= course.getStudentLimit()) {
                    throw new ResourceLimitFullException("Student limit reached");
                }

                Enrollment e = new Enrollment();
                e.setStudent(student);
                e.setCourse(course);
                er.save(e);

                course.setStudentEnrolledCount(course.getStudentEnrolledCount() + 1);
                course.getStudents().add(student);
                cr.save(course);

                student.getEnrolledCourses().add(course);
                sr.save(student);

                return e;
            } catch (OptimisticLockException ex) {
                // retry
            }
        }

        throw new RuntimeException("Failed to enroll student after multiple attempts due to concurrent updates");
    }

}
