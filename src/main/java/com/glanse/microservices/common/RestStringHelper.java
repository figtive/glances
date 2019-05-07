package com.glanse.microservices.common;

public class RestStringHelper {
    private String message;

    public RestStringHelper() {}

    public RestStringHelper(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
