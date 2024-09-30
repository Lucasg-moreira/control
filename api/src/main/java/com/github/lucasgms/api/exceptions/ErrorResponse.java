package com.github.lucasgms.api.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String message;
    private String details;
    private HttpStatus statusCode;

    public ErrorResponse(String message, String details, HttpStatus statusCode) {
        this.message = message;
        this.details = details;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
