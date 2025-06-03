package com.ElectiveManagment.ElectiveManagment.service.Impl;


import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.dto.LoginRequest;
import com.ElectiveManagment.ElectiveManagment.dto.SignupRequest;
import com.ElectiveManagment.ElectiveManagment.entity.Faculty;
import com.ElectiveManagment.ElectiveManagment.entity.Students;
import com.ElectiveManagment.ElectiveManagment.exceptions.ResourceNotFoundException;
import com.ElectiveManagment.ElectiveManagment.repository.FacultyRepository;
import com.ElectiveManagment.ElectiveManagment.repository.StudentRepository;
import com.ElectiveManagment.ElectiveManagment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private FacultyRepository facultyRepo;

    @Override
    public ResponseEntity<ApiSuccessMessgage<String>> signup(SignupRequest request) {
        ApiSuccessMessgage<String> response = new ApiSuccessMessgage<>();

        if (request.getRole().equalsIgnoreCase("student")) {
            Students s = new Students();
            s.setFirstName(request.getFirstName());
            s.setLastName(request.getLastName());
            s.setEmail(request.getEmail());
            s.setPassword(request.getPassword());
            s.setNumber(request.getNumber());
            s.setCgpa(request.getCgpa());
            s.setRollNumber(request.getRollNumber());
            s.setBranch(request.getBranch());

            studentRepo.save(s);

            response.setSuccess(true);
            response.setMessage("Student registered successfully!");
            response.setBody(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else if (request.getRole().equalsIgnoreCase("faculty")) {
            Faculty f = new Faculty();
            f.setFirstName(request.getFirstName());
            f.setLastName(request.getLastName());
            f.setEmail(request.getEmail());
            f.setPassword(request.getPassword());
            f.setNumber(request.getNumber());
            f.setDpt(request.getDpt());

            facultyRepo.save(f);

            response.setSuccess(true);
            response.setMessage("Faculty registered successfully!");
            response.setBody(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            throw new ResourceNotFoundException("Invalid role provided: " + request.getRole());
        }
    }

    @Override
    public ResponseEntity<ApiSuccessMessgage<String>> login(LoginRequest request) {
        ApiSuccessMessgage<String> response = new ApiSuccessMessgage<>();

        Optional<Students> studentOpt = studentRepo.findByEmail(request.getEmail());
        if (studentOpt.isPresent()) {
            if (studentOpt.get().getPassword().equals(request.getPassword())) {
                response.setSuccess(true);
                response.setMessage("Student login successful!");
                response.setBody(null);
                return ResponseEntity.ok(response);
            } else {
                throw new ResourceNotFoundException("Incorrect password for student.");
            }
        }

        Optional<Faculty> facultyOpt = facultyRepo.findByEmail(request.getEmail());
        if (facultyOpt.isPresent()) {
            if (facultyOpt.get().getPassword().equals(request.getPassword())) {
                response.setSuccess(true);
                response.setMessage("Faculty login successful!");
                response.setBody(null);
                return ResponseEntity.ok(response);
            } else {
                throw new ResourceNotFoundException("Incorrect password for faculty.");
            }
        }

        throw new ResourceNotFoundException("User not found with email: " + request.getEmail());
    }
}
