package com.dept.assignment.week2.mvc.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeValidator implements ConstraintValidator<PrimeValidation, Integer> {
    @Override
    public void initialize(PrimeValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer val, ConstraintValidatorContext constraintValidatorContext) {
        if(val==null) return false;
        return isPrime(val);
    }

    private boolean isPrime(Integer val) {
        if(val<1)
            return false;
        for(int i=2;i<=Math.sqrt(val);i++)
        {
            if(val%i==0)
                return false;
        }
        return true;
    }
}
