package com.kostin.first.validation;

import com.kostin.first.validation.annotation.ValidText;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTextValidator implements ConstraintValidator<ValidText, CharSequence> {


    @Override
    public void initialize(ValidText constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.matches("\\b(?!fuck\\b)\\w+", charSequence);
    }
}
