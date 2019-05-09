package com.godlike.validator.oss.exception;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponseBody {
    @NonNull
    private String error;
}
