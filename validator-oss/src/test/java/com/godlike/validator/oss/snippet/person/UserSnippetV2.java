package com.godlike.validator.oss.snippet.person;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.restdocs.request.RequestParametersSnippet;

public class UserSnippetV2 {
    public static RequestParametersSnippet listRequest() {
        return RequestDocumentation.requestParameters(
                RequestDocumentation.parameterWithName("phone").description("电话号码").optional(),
                RequestDocumentation.parameterWithName("sex").description("性别").optional()
        );
    }

    public static ResponseFieldsSnippet listResponse() {
        FieldDescriptor[] fields = new FieldDescriptor[]{
                PayloadDocumentation.fieldWithPath("phone").description("电话号码").type(JsonFieldType.STRING),
                PayloadDocumentation.fieldWithPath("sex").description("性别").type(JsonFieldType.STRING),
                PayloadDocumentation.fieldWithPath("name").description("姓名").type(JsonFieldType.STRING),
                PayloadDocumentation.fieldWithPath("idNumber").description("身份证号").type(JsonFieldType.STRING),
                PayloadDocumentation.fieldWithPath("id").description("唯一标识").type(JsonFieldType.STRING),
                PayloadDocumentation.fieldWithPath("delete").description("是否删除（true:删除，false:未删除）").type(JsonFieldType.BOOLEAN),
        };
        return PayloadDocumentation.responseFields(PayloadDocumentation.fieldWithPath("[]").description("用户列表").type(JsonFieldType.ARRAY)).andWithPrefix("[].", fields);
    }

}

