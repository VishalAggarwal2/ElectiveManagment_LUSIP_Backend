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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FirstComeFirstServeEnrollCourseStrategy implements EnrollCourseStrategy {

    @Autowired
    CourseRepository cr;

    @Autowired
    StudentRepository sr;

    @Autowired
    EnrollmentRepository er;

    @Transactional
    @Override
    public Enrollment enrollStudent(int courseId, int studentId) {

        for (int attempt = 0; attempt < 3; attempt++) {
            try {
                Course course = cr.findById(courseId)
                        .orElseThrow(() -> new ResourceNotFoundException("Course Not Found Exception"));

                Students student = sr.findById(studentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Student Not Found Exception"));

                int numberOfStudents = course.getStudentEnrolledCount();
                int studentLimit = course.getStudentLimit();

                if (numberOfStudents >= studentLimit) {
                    throw new ResourceLimitFullException("Student Limit Reached");
                }

                Enrollment enrollment = new Enrollment();
                enrollment.setStudent(student);
                enrollment.setCourse(course);
                er.save(enrollment);

                course.setStudentEnrolledCount(numberOfStudents + 1);
                course.getStudents().add(student);
                cr.save(course);

                student.getEnrolledCourses().add(course);
                sr.save(student);

                return enrollment;
            } catch (OptimisticLockException e) {
                // Retry on version conflict
                if (attempt == 2) {
                    throw new RuntimeException("Too many concurrent enrollments. Please try again.");
                }
            }
        }

        throw new RuntimeException("Enrollment failed due to concurrent updates");
    }
}
