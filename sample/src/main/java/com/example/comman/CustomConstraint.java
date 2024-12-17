package com.example.comman;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


    @Documented
    @Target(value = {ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = CustomValidator.class)
    @ReportAsSingleViolation
    @Size(min=8, max=16)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9.?/-]+$")
    public @interface CustomConstraint {
        String message() default "{error.password}";

        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};

    }
