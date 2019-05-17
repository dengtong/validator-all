package com.godlike.validator.oss;

import com.godlike.validator.oss.config.SpringRestDocsConfig;
import com.godlike.validator.oss.constant.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import(SpringRestDocsConfig.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "api.godlike.com", uriPort = 443)
public class ValidatorOssApplicationTests {
    @Test
    public void contextLoads() {
    }

    public static final String getUrlTemplate(String url) {
        if (StringUtils.isEmpty(url))
            return "";
        if (StringUtils.isEmpty(Constant.CONTEXT_PATH)) {
            return url;
        }
        StringBuffer stringBuffer = new StringBuffer(Constant.CONTEXT_PATH);
        stringBuffer.append(url);
        return stringBuffer.toString();
    }

    public static final String getContextPath() {
        if (StringUtils.isEmpty(Constant.CONTEXT_PATH)) {
            return "";
        }
        return Constant.CONTEXT_PATH;
    }
}
