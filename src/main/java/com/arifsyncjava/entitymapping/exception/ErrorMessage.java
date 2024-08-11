package com.arifsyncjava.entitymapping.exception;

public enum ErrorMessage {

    RESOURCE_NOT_FOUND ("Resource not found. try again with valid identity"),
    EMAIL_AlREADY_USED ("Email already used. try again with new email"),
    CUSTOMER_NOT_FOUND ("Customer not found with requested email");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }






}
