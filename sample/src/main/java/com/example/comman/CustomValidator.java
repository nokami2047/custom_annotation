package com.example.comman;

import java.text.MessageFormat;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Size;


public class CustomValidator implements ConstraintValidator<CustomConstraint, String> {

    private int min;
    private int max;

    @Override
    public void initialize(CustomConstraint constraintAnnotation) {
        min = constraintAnnotation.annotationType()
                .getAnnotation(Size.class).min();
        max = constraintAnnotation.annotationType()
                .getAnnotation(Size.class).max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        String message = MessageFormat.format(
                context.getDefaultConstraintMessageTemplate(),
                min, max
        );

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
                
        return value != null && value.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9.?/-]+$");
    }
}
