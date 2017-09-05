package com.example.app.model.parsers.util;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidationUtil {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();;

    public ValidationUtil() {

    }

    public static <T> boolean isValid (T t) {
        return t != null && validator.validate(t).size() == 0;
    }

    public static <T> boolean isValidProduct (T t) {
        return t != null;
    }
}
