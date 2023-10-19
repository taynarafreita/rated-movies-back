package com.personalproject.ratedmovies.validation;

import com.personalproject.ratedmovies.enums.MovieCategoryEnum;
import com.personalproject.ratedmovies.interfaces.ValidCategoryEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoryEnumValidator implements ConstraintValidator<ValidCategoryEnum, MovieCategoryEnum> {

    @Override
    public void initialize(ValidCategoryEnum constraintAnnotation) {}

    @Override
    public boolean isValid(MovieCategoryEnum value, ConstraintValidatorContext context) {
        for (MovieCategoryEnum categoryEnum : MovieCategoryEnum.values()) {
            if (categoryEnum == value) {
                return true;
            }
        }
        return false;
    }
}
