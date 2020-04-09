package com.godlike.validator.oss.response;

import lombok.Getter;

/**
 * description
 *
 * @Author: dengtong
 * @Date: 2020/4/9
 */
@Getter
public enum ResponseCode {
    SUCCESS("200899", "操作成功"),

    ERROR("500898", "未知错误"),

    JSON_PROCESSING_EXCEPTION("500899", "json化失败");

    private String code;
    private String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
