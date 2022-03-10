package com.dogood.dogoodtest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordTypeNotFound extends RuntimeException{

    public RecordTypeNotFound(String message) {
        super(String.format("RecordType %s not found", message));
        log.warn("RecordTypeNotFound: {}", message);
    }
}
