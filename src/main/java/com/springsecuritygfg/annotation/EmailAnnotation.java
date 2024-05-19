package com.springsecuritygfg.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.springsecuritygfg.validator.EmailValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailAnnotation {

    public String message() default "Email is not valid";

	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
