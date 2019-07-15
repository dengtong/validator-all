package com.godlike.validator.oss.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ForbiddenException extends Exception {
    private String code;

    public ForbiddenException(String message, String code) {
        super(message);
        this.code = code;
    }
}