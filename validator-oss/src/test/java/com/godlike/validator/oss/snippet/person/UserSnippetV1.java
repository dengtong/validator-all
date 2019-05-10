package com.godlike.validator.oss.snippet.person;

import com.godlike.validator.oss.constraint.ConstrainedFields;
import com.godlike.validator.oss.vo.person.UserVoV1;
import org.springframework.restdocs.payload.*;
import org.springframework.restdocs.request.PathParametersSnippet;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.restdocs.request.RequestParametersSnippet;

public class UserSnippetV1 {
    public static RequestParametersSnippet listRequest() {
        return RequestDocumentation.requestParameters(
                RequestDocumentation.parameterWithName("phone").description("电话号码").optional()
        );
    }

    public static ResponseFieldsSnippet listResponse() {
        FieldDescriptor[] fields = new FieldDescriptor[]{
                PayloadDocumentation.fieldWithPath("phone").description("电话号码"),
                PayloadDocumentation.fieldWithPath("name").description("姓名").type(JsonFieldType.STRING),
                PayloadDocumentation.fieldWithPath("idNumber").description("身份证号").type(JsonFieldType.STRING),
                PayloadDocumentation.fieldWithPath("id").description("唯一标识").type(JsonFieldType.STRING),
                PayloadDocumentation.fieldWithPath("delete").description("是否删除（true:删除，false:未删除）").type(JsonFieldType.BOOLEAN),
        };
        return PayloadDocumentation.responseFields(PayloadDocumentation.fieldWithPath("[]").description("用户列表").type(JsonFieldType.ARRAY)).andWithPrefix("[].", fields);
    }

    public static PathParametersSnippet getRequest() {
        return RequestDocumentation.pathParameters(
                RequestDocumentation.parameterWithName("id").description("用户id"));
    }

    public static ResponseFieldsSnippet getResponse() {
        FieldDescriptor[] fields = new FieldDescriptor[]{
                PayloadDocumentation.fieldWithPath("nickName").description("昵称").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("profilePhoto").description("头像").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("sex").description("性别").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("politicalStatus").description("政治面貌").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("birthPlace").description("出生地").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("residence").description("居住地").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("industry").description("行业").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("company").description("公司").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("department").description("部门").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("employeeNumber").description("员工号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("address").description("收货地址").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("name").description("姓名").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("idNumber").description("身份证号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("wxNumber").description("微信号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("password").description("密码").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("id").description("唯一标识").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("delete").description("是否删除（true:删除，false:未删除）").type(JsonFieldType.BOOLEAN).optional(),
                PayloadDocumentation.fieldWithPath("birthday").description("生日").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("studentNumber").description("学生好").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("phone").description("电话号码").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("email").description("电子邮件").type(JsonFieldType.STRING).optional()};
        return PayloadDocumentation.responseFields(fields);
    }

    public static RequestFieldsSnippet createRequest() {
        ConstrainedFields userVoConstrainedFields = new ConstrainedFields(UserVoV1.class);
        return PayloadDocumentation.requestFields(
                userVoConstrainedFields.fieldWithPath("phone").description("电话号码"),
                userVoConstrainedFields.fieldWithPath("email").description("电子邮件").type(JsonFieldType.STRING).optional()
        );
    }

    public static ResponseFieldsSnippet createResponse() {
        FieldDescriptor[] fields = new FieldDescriptor[]{
                PayloadDocumentation.fieldWithPath("nickName").description("昵称").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("profilePhoto").description("头像").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("sex").description("性别").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("politicalStatus").description("政治面貌").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("birthPlace").description("出生地").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("residence").description("居住地").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("industry").description("行业").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("company").description("公司").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("department").description("部门").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("employeeNumber").description("员工号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("address").description("收货地址").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("name").description("姓名").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("idNumber").description("身份证号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("wxNumber").description("微信号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("password").description("密码").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("id").description("唯一标识").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("delete").description("是否删除（true:删除，false:未删除）").type(JsonFieldType.BOOLEAN).optional(),
                PayloadDocumentation.fieldWithPath("birthday").description("生日").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("studentNumber").description("学生好").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("phone").description("电话号码").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("email").description("电子邮件").type(JsonFieldType.STRING).optional()};
        return PayloadDocumentation.responseFields(fields);
    }

    public static PathParametersSnippet updateRequestPathParameters() {
        return RequestDocumentation.pathParameters(
                RequestDocumentation.parameterWithName("id").description("用户id"));
    }

    public static RequestFieldsSnippet updateRequestFields() {
        ConstrainedFields userVoConstrainedFields = new ConstrainedFields(UserVoV1.class);
        return PayloadDocumentation.requestFields(
                userVoConstrainedFields.fieldWithPath("phone").description("电话号码"),
                userVoConstrainedFields.fieldWithPath("email").description("电子邮件").type(JsonFieldType.STRING).optional()
        );
    }

    public static ResponseFieldsSnippet updateResponse() {
        FieldDescriptor[] fields = new FieldDescriptor[]{
                PayloadDocumentation.fieldWithPath("nickName").description("昵称").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("profilePhoto").description("头像").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("sex").description("性别").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("politicalStatus").description("政治面貌").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("birthPlace").description("出生地").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("residence").description("居住地").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("industry").description("行业").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("company").description("公司").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("department").description("部门").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("employeeNumber").description("员工号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("address").description("收货地址").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("name").description("姓名").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("idNumber").description("身份证号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("wxNumber").description("微信号").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("password").description("密码").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("id").description("唯一标识").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("delete").description("是否删除（true:删除，false:未删除）").type(JsonFieldType.BOOLEAN).optional(),
                PayloadDocumentation.fieldWithPath("birthday").description("生日").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("studentNumber").description("学生好").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("phone").description("电话号码").type(JsonFieldType.STRING).optional(),
                PayloadDocumentation.fieldWithPath("email").description("电子邮件").type(JsonFieldType.STRING).optional()};
        return PayloadDocumentation.responseFields(fields);
    }

    public static PathParametersSnippet deleteRequest() {
        return RequestDocumentation.pathParameters(
                RequestDocumentation.parameterWithName("id").description("用户id"));
    }
}

