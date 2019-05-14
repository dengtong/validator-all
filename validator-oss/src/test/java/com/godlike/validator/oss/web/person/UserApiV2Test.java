package com.godlike.validator.oss.web.person;

import com.godlike.validator.oss.ValidatorOssApplicationTests;
import com.godlike.validator.oss.snippet.person.UserSnippetV2;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

public class UserApiV2Test extends ValidatorOssApplicationTests {
    @Resource
    private MockMvc mockMvc;

    @Test
    public void list() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get(getUrlTemplate("/user/v2"))
                .param("phone", "18501995564").param("sex", "男")
                .contextPath(getContextPath())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[:1].phone").value("18501995564"))
                .andDo(MockMvcRestDocumentation.document("user/v2/list",
                        UserSnippetV2.listRequest(), UserSnippetV2.listResponse()));
    }
}

