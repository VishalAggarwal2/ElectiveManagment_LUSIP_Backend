package com.ElectiveManagment.ElectiveManagment.exceptions;

public class ResourceLimitFullException extends RuntimeException{
    public ResourceLimitFullException(String message){
        super(message);
    }
}
