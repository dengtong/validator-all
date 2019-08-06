package com.godlike.validator.oss.config;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.restdocs.cli.CliDocumentation;
import org.springframework.restdocs.http.HttpDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.templates.TemplateFormats;

@TestConfiguration
public class SpringRestDocsConfig implements RestDocsMockMvcConfigurationCustomizer {
    @Override
    public void customize(MockMvcRestDocumentationConfigurer configurer) {
//        该处配置的uri属性会被@AutoConfigureRestDocs的配置覆盖，因此uri属性必须在@AutoConfigureRestDocs上进行配置
//        configurer.uris().withScheme("https").withHost("example.com").withPort(443);
        configurer.operationPreprocessors().withRequestDefaults(Preprocessors.prettyPrint()).withResponseDefaults(Preprocessors.prettyPrint());
        configurer.snippets().withDefaults(HttpDocumentation.httpRequest() , HttpDocumentation.httpResponse()).withTemplateFormat(TemplateFormats.asciidoctor()).withEncoding("UTF-8");
    }
}
