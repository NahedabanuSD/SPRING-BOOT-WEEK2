package com.dept.assignment.week2.mvc.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {PrimeValidator.class})
public @interface PrimeValidation {
    String message() default "primeNum should be Prime";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
