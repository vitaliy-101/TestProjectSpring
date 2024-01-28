package com.kostin.first.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.kostin.first.validation.ValidTextValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidTextValidator.class)
public @interface ValidText {
    String message() default "Invalid text";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
