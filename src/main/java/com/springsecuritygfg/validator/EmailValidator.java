package com.springsecuritygfg.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.springsecuritygfg.annotation.EmailAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailAnnotation, String> {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}