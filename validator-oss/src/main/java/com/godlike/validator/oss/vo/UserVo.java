package com.godlike.validator.oss.vo;

import com.fasterxml.jackson.annotation.JsonView;
import com.godlike.validator.oss.validator.Phone;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;
import java.util.Date;

@Data
public class UserVo {
    @JsonView({GetViewV1.class})
    private String nickName;
    @JsonView({GetViewV1.class})
    private String profilePhoto;
    @JsonView({GetViewV1.class})
    private String sex;
    private String politicalStatus;
    private String birthPlace;
    private String residence;
    private String industry;
    @Email
    private String email;
    @NotBlank(message = "请输入手机号", groups = {CreateGroupV1.class})
    @Phone(message = "请输入正确的手机号", groups = {UpdateGroupV1.class, CreateGroupV1.class})
    @JsonView({ListViewV1.class})
    private String phone;
    private String company;
    private String department;
    private String employeeNumber;
    private String studentNumber;
    @Valid
    private Address address;
    @JsonView({ListViewV1.class})
    private String name;
    @JsonView({ListViewV1.class})
    private String idNumber;
    private String wxNumber;
    private String password;
    @NotBlank(message = "id不能为空", groups = {UpdateGroupV1.class})
    @JsonView({ListViewV1.class})
    private String id;
    @JsonView({ListViewV1.class})
    private boolean delete;
    private Date birthday;

    public interface ListViewV1 {
    }

    public interface GetViewV1 extends ListViewV1 {
    }

    public interface CreateGroupV1 extends Default {
    }

    public interface UpdateGroupV1 extends Default {
    }
}
