package net.andreinc.jvbe.misc.validators;

import net.andreinc.jvbe.misc.NotInstanceOf;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotInstanceOfValidator implements ConstraintValidator<NotInstanceOf, Object> {

    private NotInstanceOf annotation;

    @Override
    public void initialize(NotInstanceOf constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (null == value) {
            return false;
        }

        Class<?>[] classes = annotation.value();

        for(Class<?> cls : classes) {
            if (cls.isInstance(value)) {
                return false;
            }
        }

        return true;
    }
}
