package com.StudentErp.project.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class CustomeExceptionhandler{

    @ExceptionHandler(value = StudentNotFoundException.class)
   public ResponseEntity<ExceptionResponse> handleStudentNotFoundException(){
       ExceptionResponse exceptionResponse=new ExceptionResponse("sorry student not found!!", 404L,new Date());
       return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
