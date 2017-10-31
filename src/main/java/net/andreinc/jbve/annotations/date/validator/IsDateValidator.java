package net.andreinc.jbve.annotations.date.validator;


import net.andreinc.jbve.annotations.date.IsDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class IsDateValidator implements ConstraintValidator<IsDate, String> {

    private IsDate annotation;

    @Override
    public void initialize(IsDate constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (isEmpty(value)) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(annotation.value());
        try {
            sdf.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
