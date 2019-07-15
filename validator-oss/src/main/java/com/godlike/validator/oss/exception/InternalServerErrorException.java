package com.godlike.validator.oss.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InternalServerErrorException extends Exception {
    private String code;

    public InternalServerErrorException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public InternalServerErrorException(String message, String code) {
        super(message);
        this.code = code;
    }
}