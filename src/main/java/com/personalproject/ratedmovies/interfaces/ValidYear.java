package com.personalproject.ratedmovies.interfaces;

import com.personalproject.ratedmovies.validation.YearValidator;
import jakarta.validation.Constraint;

import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = YearValidator.class)
public @interface ValidYear {
    String message() default "Year must be a number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
