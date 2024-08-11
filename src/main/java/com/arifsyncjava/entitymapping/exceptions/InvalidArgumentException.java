package com.arifsyncjava.entitymapping.exceptions;

import com.arifsyncjava.entitymapping.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvalidArgumentException extends BaseException {
    public InvalidArgumentException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
