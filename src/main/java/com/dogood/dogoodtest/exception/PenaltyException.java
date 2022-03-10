package com.dogood.dogoodtest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PenaltyException extends RuntimeException{

    public PenaltyException() {
        super("User is not admin");
        log.warn("Not admin is trying record penalty");
    }
}
