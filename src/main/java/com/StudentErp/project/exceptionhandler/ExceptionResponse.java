package com.StudentErp.project.exceptionhandler;


import java.util.Date;

public class ExceptionResponse {

    private String message;
    private Long statusCode;
    private Date date;

    public ExceptionResponse(String message, Long statusCode, Date date) {
        this.message = message;
        this.statusCode = statusCode;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
