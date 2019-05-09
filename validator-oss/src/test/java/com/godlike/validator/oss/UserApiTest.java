package com.godlike.validator.oss;

import com.godlike.validator.oss.vo.UserVo;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.snippet.Attributes.key;

public class UserApiTest extends ValidatorOssApplicationTests {
    @Resource
    private MockMvc mockMvc;

    @Test
    public void listUser() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/v1/user")
                .param("phone", "18501995564")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[:1].phone").value("18501995564"))
                .andDo(MockMvcRestDocumentation.document("user/list-user",
                        RequestDocumentation.requestParameters(
                                RequestDocumentation.parameterWithName("phone").description("电话号码").optional()
                        ),
                        PayloadDocumentation.responseFields(fieldWithPath("[]").description("用户列表")).andWithPrefix("[].", userVoFieldDescriptor))
                );
    }


    @Test
    public void getUser() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/v1/user/{id}", 123456)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(123456))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nickName").value("cat"))
                .andDo(MockMvcRestDocumentation.document("user/get-user", RequestDocumentation.pathParameters(
                        RequestDocumentation.parameterWithName("id").description("用户id"))));
    }

    @Test
    public void createUser() throws Exception {
        ConstrainedFields userVoConstrainedFields = new ConstrainedFields(UserVo.class);
        String content = "{\"phone\":\"18501995564\"}";
        mockMvc.perform(RestDocumentationRequestBuilders.post("/v1/user")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("18501995564"))
                .andDo(MockMvcRestDocumentation.document("user/create-user",
                        PayloadDocumentation.requestFields(
                                userVoConstrainedFields.withPath("phone").description("电话号码"),
                                userVoConstrainedFields.withPath("email").description("电子邮件").type(JsonFieldType.STRING).optional()
                        ),
                        PayloadDocumentation.responseFields(userVoFieldDescriptor)
                ));
    }

    private static class ConstrainedFields {

        private final ConstraintDescriptions constraintDescriptions;

        ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path) {
            System.out.println("abc:"+StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". "));
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". ")));
        }
    }

    FieldDescriptor[] userVoFieldDescriptor = new FieldDescriptor[]{
            fieldWithPath("nickName").description("昵称").type(JsonFieldType.STRING).optional(),
            fieldWithPath("profilePhoto").description("头像").type(JsonFieldType.STRING).optional(),
            fieldWithPath("sex").description("性别").type(JsonFieldType.STRING).optional(),
            fieldWithPath("politicalStatus").description("政治面貌").type(JsonFieldType.STRING).optional(),
            fieldWithPath("birthPlace").description("出生地").type(JsonFieldType.STRING).optional(),
            fieldWithPath("residence").description("居住地").type(JsonFieldType.STRING).optional(),
            fieldWithPath("industry").description("行业").type(JsonFieldType.STRING).optional(),
            fieldWithPath("company").description("公司").type(JsonFieldType.STRING).optional(),
            fieldWithPath("department").description("部门").type(JsonFieldType.STRING).optional(),
            fieldWithPath("employeeNumber").description("员工号").type(JsonFieldType.STRING).optional(),
            fieldWithPath("address").description("收货地址").type(JsonFieldType.STRING).optional(),
            fieldWithPath("name").description("姓名").type(JsonFieldType.STRING).optional(),
            fieldWithPath("idNumber").description("身份证号").type(JsonFieldType.STRING).optional(),
            fieldWithPath("wxNumber").description("微信号").type(JsonFieldType.STRING).optional(),
            fieldWithPath("password").description("密码").type(JsonFieldType.STRING).optional(),
            fieldWithPath("id").description("唯一标识").type(JsonFieldType.STRING).optional(),
            fieldWithPath("delete").description("是否删除（true:删除，false:未删除）").type(JsonFieldType.BOOLEAN).optional(),
            fieldWithPath("birthday").description("生日").type(JsonFieldType.STRING).optional(),
            fieldWithPath("studentNumber").description("学生好").type(JsonFieldType.STRING).optional(),
            fieldWithPath("phone").description("电话号码"),
            fieldWithPath("email").description("电子邮件").type(JsonFieldType.STRING).optional()};

}
