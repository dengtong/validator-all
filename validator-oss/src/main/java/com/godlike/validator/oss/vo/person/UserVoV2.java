package com.godlike.validator.oss.vo.person;

import com.fasterxml.jackson.annotation.JsonView;
import com.godlike.validator.oss.validator.Phone;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;
import java.util.Date;

@Data
public class UserVoV2 {
    @JsonView({GetView.class})
    private String nickName;
    @JsonView({GetView.class})
    private String profilePhoto;
    @JsonView({ListView.class})
    private String sex;
    private String politicalStatus;
    private String birthPlace;
    private String residence;
    private String industry;
    @Email
    private String email;
    @NotBlank(message = "请输入手机号", groups = {CreateGroup.class})
    @Phone(message = "请输入正确的手机号", groups = {UpdateGroup.class, CreateGroup.class})
    @JsonView({ListView.class})
    private String phone;
    private String company;
    private String department;
    private String employeeNumber;
    private String studentNumber;
    @Valid
    private AddressVoV1 address;
    @JsonView({ListView.class})
    private String name;
    @JsonView({ListView.class})
    private String idNumber;
    private String wxNumber;
    private String password;
    @NotBlank(message = "id不能为空", groups = {UpdateGroup.class})
    @JsonView({ListView.class})
    private String id;
    @JsonView({ListView.class})
    private boolean delete;
    private Date birthday;

    public interface ListView {
    }

    public interface GetView extends ListView {
    }

    public interface CreateGroup extends Default {
    }

    public interface UpdateGroup extends Default {
    }
}
