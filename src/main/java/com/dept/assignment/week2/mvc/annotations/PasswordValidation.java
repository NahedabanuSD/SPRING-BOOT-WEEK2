package com.dept.assignment.week2.mvc.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {PasswordValidator.class})
public @interface PasswordValidation {
    String message() default "Password of Department should contain uppercase , lower case, special character and numeric value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
