package com.arifsyncjava.entitymapping.exception;

public enum ErrorMessage {

    RESOURCE_NOT_FOUND ("Resource not found. try again with valid identity");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }






}
