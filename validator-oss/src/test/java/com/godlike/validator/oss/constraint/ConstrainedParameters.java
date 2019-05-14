package com.godlike.validator.oss.constraint;

import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.restdocs.snippet.Attributes;
import org.springframework.util.StringUtils;

public class ConstrainedParameters {
    private final ConstraintDescriptions constraintDescriptions;

    public ConstrainedParameters(Class<?> input) {
        this.constraintDescriptions = new ConstraintDescriptions(input);
    }

    public ParameterDescriptor parameterWithName(String name) {
        return RequestDocumentation.parameterWithName(name).attributes(Attributes.key("constraints").value(StringUtils
                .collectionToDelimitedString(this.constraintDescriptions.descriptionsForProperty(name), "; ")));
    }
}
