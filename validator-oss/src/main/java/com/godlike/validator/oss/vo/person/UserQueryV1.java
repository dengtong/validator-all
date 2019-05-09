package com.godlike.validator.oss.vo.person;

import com.godlike.validator.oss.validator.Phone;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserQueryV1 {
    @NotBlank(message = "手机号不能为空")
    @Phone(message = "请输入正确的手机号")
    private String phone;
}
