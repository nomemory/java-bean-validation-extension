package net.andreinc.jbvext.annotations.str.validators;

import net.andreinc.jbvext.annotations.str.Parseable;
import net.andreinc.jbvext.annotations.str.ParseableType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.function.Function;

public class ParseableValidator implements ConstraintValidator<Parseable, String> {

    private Parseable annotation;

    @Override
    public void initialize(Parseable constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return false;
        }

        ParseableType type = annotation.value();

        switch (type) {
            case TO_INT:
                return catcher(value, Integer::parseInt);
            case TO_DOUBLE:
                return catcher(value, Double::parseDouble);
            case TO_LONG:
                return catcher(value, Long::parseLong);
            case TO_SHORT:
                return catcher(value, Short::parseShort);
            case TO_FLOAT:
                return catcher(value, Float::parseFloat);
        }

        return false;
    }

    private <T> boolean catcher(String value, Function<String, T> function) {
        try {
            function.apply(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
