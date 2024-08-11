package com.arifsyncjava.entitymapping.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public BaseException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}
