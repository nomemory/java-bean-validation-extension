package net.andreinc.jbvext.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SimpleValidation {

    public static <T> void validate(T object) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> validatorSet = validator.validate(object);

        validatorSet.forEach(cv -> {
            throw new BeanValidationException(cv.getPropertyPath() + " - " + cv.getMessage());
        });
    }
}
