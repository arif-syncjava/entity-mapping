package com.arifsyncjava.entitymapping.exceptions;

import com.arifsyncjava.entitymapping.exception.BaseException;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException () {
        super(HttpStatus.NOT_FOUND,
                ErrorMessage.RESOURCE_NOT_FOUND.getMessage());
    }



}
