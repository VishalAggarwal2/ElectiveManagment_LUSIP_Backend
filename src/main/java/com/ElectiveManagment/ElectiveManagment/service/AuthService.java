package com.ElectiveManagment.ElectiveManagment.service;

import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.dto.LoginRequest;
import com.ElectiveManagment.ElectiveManagment.dto.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<ApiSuccessMessgage<String>> signup(SignupRequest request);
    ResponseEntity<ApiSuccessMessgage<String>> login(LoginRequest request);
}
