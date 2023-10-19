package com.personalproject.ratedmovies.validation;

import com.personalproject.ratedmovies.interfaces.ValidYear;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class YearValidator implements ConstraintValidator<ValidYear, Integer> {

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext context) {
        try {
            Integer.parseInt(String.valueOf(year));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
