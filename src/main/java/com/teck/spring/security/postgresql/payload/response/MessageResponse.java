package com.teck.spring.security.postgresql.payload.response;

public class MessageResponse {
    private String message;

    public  MessageResponse(String message) {
    	System.out.println("vg");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
