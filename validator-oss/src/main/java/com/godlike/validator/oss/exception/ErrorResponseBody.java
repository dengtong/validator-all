package com.godlike.validator.oss.exception;

import lombok.Data;
import lombok.NonNull;

/**
 * description
 *
 * @Author: dengtong
 * @Date: 2020/4/9
 */
@Data
public class ErrorResponseBody {
    @NonNull
    private String errorMessage;
    @NonNull
    private String errorCode;
}
