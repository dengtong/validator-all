package com.godlike.validator.oss.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ForbiddenException extends Throwable {
    private String code;
    private String message;
    private Exception rawException;

    public ForbiddenException(String message, Exception rawException, String code) {
        this.message = message;
        this.code = code;
        this.rawException = rawException;
    }

}