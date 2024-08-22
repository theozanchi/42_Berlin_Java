package de.fortytwoberlin.swingy.utils;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import java.util.Set;

public class ValidationUtil {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> void validate(T object) throws IllegalArgumentException {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> violation : violations) {
                sb.append(violation.getMessage()).append("\n");
            }
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
