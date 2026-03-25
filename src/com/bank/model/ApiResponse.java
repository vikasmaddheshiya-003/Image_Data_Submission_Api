package com.bank.model;

public class ApiResponse {

    private String status;
    private String message;

    public ApiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
    
    public String toJson() {
        return "{ \"status\": \"" + status + "\", \"message\": \"" + message + "\" }";
    }
}
