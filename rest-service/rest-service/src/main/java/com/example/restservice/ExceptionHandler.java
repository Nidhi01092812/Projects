package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.restservice.model.ErrorResponseModel;
import com.example.restservice.model.Status;


 
@ControllerAdvice
public class ExceptionHandler {
 
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorResponseModel showCustomMessage(Exception e){
 
    	ErrorResponseModel model=new ErrorResponseModel();
    	model.setStatus(Status.FAILURE);
    	model.setMessage("Numeric input expected, received invalid numbers in input");

        return model;
    }
}
