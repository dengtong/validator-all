/*
 * Copyright 2014-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.godlike.validator.oss.config;

import org.springframework.restdocs.http.HttpDocumentation;
import org.springframework.restdocs.operation.Operation;
import org.springframework.restdocs.snippet.Snippet;

import java.util.Map;

/**
 * A {@link Snippet} that documents an HTTP request.
 *
 * @author Andy Wilkinson
 * @see HttpDocumentation#httpRequest()
 * @see HttpDocumentation#httpRequest(Map)
 */
public class HttpRequestSnippet extends org.springframework.restdocs.http.HttpRequestSnippet {
    public HttpRequestSnippet() {
        super();
    }

    public HttpRequestSnippet(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    protected Map<String, Object> createModel(Operation operation) {
        Map<String, Object> model = super.createModel(operation);
        model.put("scheme", operation.getRequest().getUri().getScheme());
        return model;
    }
}
