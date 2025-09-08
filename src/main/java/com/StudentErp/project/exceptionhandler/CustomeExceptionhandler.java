package com.StudentErp.project.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomeExceptionhandler extends ResponseEntityExceptionHandler {


//  this method for handle the parent exception.

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<ExceptionResponse> handleException(Exception ex, WebRequest request) throws Exception {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), 500L, new Date());
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(value = StudentNotFoundException.class)
   public ResponseEntity<ExceptionResponse> handleStudentNotFoundException(){
       ExceptionResponse exceptionResponse=new ExceptionResponse("sorry student not found!!", 404L,new Date());
       return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
