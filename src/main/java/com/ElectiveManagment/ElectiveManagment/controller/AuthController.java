package com.ElectiveManagment.ElectiveManagment.controller;

import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.dto.LoginRequest;
import com.ElectiveManagment.ElectiveManagment.dto.SignupRequest;
import com.ElectiveManagment.ElectiveManagment.service.Impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    AuthController(AuthServiceImpl  a){
        this.authService=a;
    }


    @PostMapping("/signup")
    public ResponseEntity<ApiSuccessMessgage<String>> signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiSuccessMessgage<String>> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}
