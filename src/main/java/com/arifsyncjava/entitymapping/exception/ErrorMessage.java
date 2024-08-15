package com.arifsyncjava.entitymapping.exception;

public enum ErrorMessage {

    RESOURCE_NOT_FOUND ("Resource not found. try again with valid identity"),
    EMAIL_AlREADY_USED ("Email already used. try again with new email"),
    EMAIL_NOT_FOUND ("Email not found. try again with new email"),
    CUSTOMER_NOT_FOUND ("Customer not found with requested email"),
    DATABASE_OPERATION_ERROR ("An error occur to perform database operation");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }






}
