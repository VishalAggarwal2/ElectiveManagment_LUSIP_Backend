package com.ElectiveManagment.ElectiveManagment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/health")
public class health {

    @GetMapping
    private String getResponse(){
        return "Elective Managment Software Runing ..";
    }
}
