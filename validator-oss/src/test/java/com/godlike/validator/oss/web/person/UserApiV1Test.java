package com.godlike.validator.oss.web.person;

import com.godlike.validator.oss.ValidatorOssApplicationTests;
import com.godlike.validator.oss.snippet.person.UserSnippetV1;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

public class UserApiV1Test extends ValidatorOssApplicationTests {
    @Resource
    private MockMvc mockMvc;

    @Test
    public void list() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/user/v1")
                .param("phone", "18501995564")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[:1].phone").value("18501995564"))
                .andDo(MockMvcRestDocumentation.document("user/v1/list",
                        UserSnippetV1.listRequest(), UserSnippetV1.listResponse()));
    }


    @Test
    public void get() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/user/v1/{id}", 123456)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(123456))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nickName").value("cat"))
                .andDo(MockMvcRestDocumentation.document("user/v1/get", UserSnippetV1.getRequest(), UserSnippetV1.getResponse()));
    }

    @Test
    public void create() throws Exception {

        String content = "{\"phone\":\"18501995564\"}";
        mockMvc.perform(RestDocumentationRequestBuilders.post("/user/v1")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("18501995564"))
                .andDo(MockMvcRestDocumentation.document("user/v1/create", UserSnippetV1.createRequest(), UserSnippetV1.createResponse()));
    }

    @Test
    public void update() throws Exception {

        String content = "{\"phone\":\"18501995564\"}";
        mockMvc.perform(RestDocumentationRequestBuilders.put("/user/v1/{id}", 123456)
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("18501995564"))
                .andDo(MockMvcRestDocumentation.document("user/v1/update", UserSnippetV1.updateRequestPathParameters(), UserSnippetV1.updateRequestFields(), UserSnippetV1.updateResponse()));
    }

    @Test
    public void delete() throws Exception {

        mockMvc.perform(RestDocumentationRequestBuilders.delete("/user/v1/{id}", 123456)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcRestDocumentation.document("user/v1/delete", UserSnippetV1.deleteRequest()));
    }
}

