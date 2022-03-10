package com.dogood.dogoodtest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DonationException extends RuntimeException{

    public DonationException(String message) {
        super(String.format("Donation not possible from %s", message));
        log.warn("Donation not possible from {}", message);
    }
}
