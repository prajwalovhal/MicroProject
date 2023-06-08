package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//404
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String msg) {
        super(msg);
    }
}
