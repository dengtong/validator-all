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
    @JsonView({getUserVoView.class})
    private String nickName;
    @JsonView({getUserVoView.class})
    private String profilePhoto;
    @JsonView({getUserVoView.class})
    private String sex;
    private String politicalStatus;
    private String birthPlace;
    private String residence;
    private String industry;
    @Email
    private String email;
    @NotBlank(message = "请输入手机号", groups = {UserVoCreateGroup.class})
    @Phone(message = "请输入正确的手机号", groups = {UserVoUpdateGroup.class, UserVoCreateGroup.class})
    @JsonView({listUserVoView.class})
    private String phone;
    private String company;
    private String department;
    private String employeeNumber;
    private String studentNumber;
    @Valid
    private Address address;
    @JsonView({listUserVoView.class})
    private String name;
    @JsonView({listUserVoView.class})
    private String idNumber;
    private String wxNumber;
    private String password;
    @NotBlank(message = "id不能为空", groups = {UserVoUpdateGroup.class})
    @JsonView({listUserVoView.class})
    private String id;
    @JsonView({listUserVoView.class})
    private boolean delete;
    private Date birthday;
    public interface listUserVoView {
    }
    public interface getUserVoView extends listUserVoView {
    }
    public interface UserVoCreateGroup extends Default {
    }
    public interface UserVoUpdateGroup extends Default {
    }
}
