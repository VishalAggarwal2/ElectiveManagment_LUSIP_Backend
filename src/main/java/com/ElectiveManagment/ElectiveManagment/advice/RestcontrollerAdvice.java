package com.ElectiveManagment.ElectiveManagment.advice;

import com.ElectiveManagment.ElectiveManagment.dto.ApiSuccessMessgage;
import com.ElectiveManagment.ElectiveManagment.exceptions.ConditionNotMeetException;
import com.ElectiveManagment.ElectiveManagment.exceptions.ResourceLimitFullException;
import com.ElectiveManagment.ElectiveManagment.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// Rest Controller Advice is The Annotation which is applicable on our every rest controller
// functions
@RestControllerAdvice
public class RestcontrollerAdvice {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiSuccessMessgage<String>> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiSuccessMessgage<String> response = new ApiSuccessMessgage<>();
        response.setBody(null);
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceLimitFullException.class)
    public ResponseEntity<ApiSuccessMessgage<String>> handleResourceLimitFound(ResourceLimitFullException ex) {
        ApiSuccessMessgage<String> response = new ApiSuccessMessgage<>();
        response.setBody(null);
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(ConditionNotMeetException.class)
    public ResponseEntity<ApiSuccessMessgage<String>> conditionNotMeetE(ResourceLimitFullException ex) {
        ApiSuccessMessgage<String> response = new ApiSuccessMessgage<>();
        response.setBody(null);
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }




}
