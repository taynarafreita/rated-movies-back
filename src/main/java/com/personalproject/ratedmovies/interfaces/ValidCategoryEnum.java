package com.personalproject.ratedmovies.interfaces;

import com.personalproject.ratedmovies.validation.CategoryEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryEnumValidator.class)
public @interface ValidCategoryEnum {
    String message() default "Category must be a valid categoryEnum";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
