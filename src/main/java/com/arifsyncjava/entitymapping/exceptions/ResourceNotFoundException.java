package com.arifsyncjava.entitymapping.exceptions;

import com.arifsyncjava.entitymapping.exception.BaseException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException (String message) {
        super(HttpStatus.NOT_FOUND, message  );
    }



}
