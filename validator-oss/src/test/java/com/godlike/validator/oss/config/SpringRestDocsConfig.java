package com.godlike.validator.oss.config;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.templates.TemplateFormats;

@TestConfiguration
public class SpringRestDocsConfig implements RestDocsMockMvcConfigurationCustomizer {
    @Override
    public void customize(MockMvcRestDocumentationConfigurer configurer) {
        configurer.uris().withScheme("https").withHost("example.com").withPort(443);
        configurer.operationPreprocessors().withRequestDefaults(Preprocessors.prettyPrint()).withResponseDefaults(Preprocessors.prettyPrint());
        configurer.snippets().withTemplateFormat(TemplateFormats.asciidoctor()).withEncoding("UTF-8");
    }
}
