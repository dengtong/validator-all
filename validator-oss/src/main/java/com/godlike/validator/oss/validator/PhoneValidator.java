package com.godlike.validator.oss.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        return value.matches("^[1][3,4,5,7,8][0-9]{9}$");
    }

    @Override
    public void initialize(Phone constraintAnnotation) {

    }
}
