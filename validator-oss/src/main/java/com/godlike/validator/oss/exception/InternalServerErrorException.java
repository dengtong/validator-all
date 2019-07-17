package com.godlike.validator.oss.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InternalServerErrorException extends Throwable {
    private String code;
    private String message;
    private Exception rawException;

    public InternalServerErrorException(String message, Exception rawException, String code) {
        this.message = message;
        this.code = code;
        this.rawException = rawException;
    }

}