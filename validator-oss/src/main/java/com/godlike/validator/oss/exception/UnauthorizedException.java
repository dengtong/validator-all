package com.godlike.validator.oss.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UnauthorizedException extends Exception {
    private String code;

    public UnauthorizedException(String message, String code) {
        super(message);
        this.code = code;
    }

}
