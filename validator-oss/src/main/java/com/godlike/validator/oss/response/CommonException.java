package com.godlike.validator.oss.response;

import lombok.Getter;

/**
 * description
 *
 * @Author: dengtong
 * @Date: 2020/4/9
 */
@Getter
public class CommonException extends RuntimeException {
    private ResponseCode responseCode;

    public CommonException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

}
