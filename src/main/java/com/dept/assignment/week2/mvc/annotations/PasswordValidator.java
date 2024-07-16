package com.dept.assignment.week2.mvc.annotations;

import com.dept.assignment.week2.mvc.exceptions.ResourceNotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{10,}$";
    private final Pattern pattern=Pattern.compile(PASSWORD_PATTERN);
    @Override
    public boolean isValid(String pwd, ConstraintValidatorContext constraintValidatorContext) {

        if(pwd==null)
            throw new ResourceNotFoundException("Password Cannot be Null");
        return pattern.matcher(pwd).matches();

    }
}
