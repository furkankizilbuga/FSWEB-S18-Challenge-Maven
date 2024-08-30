package com.workintech.fswebs18challengemaven.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Slf4j
public class CardException extends RuntimeException {

    private HttpStatus httpStatus;

    public CardException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        log.info("exception occurred");
    }

}
