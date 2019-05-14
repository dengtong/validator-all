package com.godlike.validator.oss.vo.person;

import com.godlike.validator.oss.validator.constraints.Phone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
public class AddressVoV1 {
    private String consignee;
    @NotBlank(message = "收货人手机号不能为空")
    @Phone(message = "请输入正确的收货人手机号")
    private String phone;
    private String province;
    private String city;
    private String district;
    private String town;
    private Boolean isDefault;
}
