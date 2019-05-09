package com.godlike.validator.oss;

import com.godlike.validator.oss.config.SpringRestDocsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import(SpringRestDocsConfig.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class ValidatorOssApplicationTests {

    @Test
    public void contextLoads() {
    }
}
