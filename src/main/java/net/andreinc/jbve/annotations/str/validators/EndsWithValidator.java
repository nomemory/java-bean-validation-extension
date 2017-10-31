package net.andreinc.jbve.annotations.str.validators;

import net.andreinc.jbve.annotations.str.EndsWith;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.function.BiFunction;

public class EndsWithValidator implements ConstraintValidator<EndsWith, String> {

    protected EndsWith annotation;

    @Override
    public void initialize(EndsWith constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String[] prefixes = annotation.value();

        BiFunction<String, String, Boolean> fct =
                !annotation.ignoreCase() ?
                        StringUtils::endsWith :
                        StringUtils::endsWithIgnoreCase;

        for(String p : prefixes) {
            if (fct.apply(value, p)) {
                return true;
            }
        }

        return false;
    }
}
