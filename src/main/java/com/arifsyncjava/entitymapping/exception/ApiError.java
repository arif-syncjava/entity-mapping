package com.arifsyncjava.entitymapping.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ApiError {
    private LocalDateTime timeStamp;
    private int status;
    private String error;

    public ApiError() {
    }

    public ApiError(HttpStatus status, String error) {
        this.timeStamp = LocalDateTime.now();
        this.status = status.value();
        this.error = error;
    }



}
