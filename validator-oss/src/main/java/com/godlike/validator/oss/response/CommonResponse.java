package com.godlike.validator.oss.response;

import lombok.Getter;

@Getter
public class CommonResponse<T> {

    private String code;

    private String msg;

    private T data;

    public CommonResponse(T data) {
        this(ResponseCode.SUCCESS, data);
    }

    public CommonResponse(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    protected CommonResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
