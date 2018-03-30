package net.andreinc.jbvext.annotations.date.validator;


import net.andreinc.jbvext.annotations.date.Before;
import net.andreinc.jbvext.annotations.date.IsDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class BeforeValidator implements ConstraintValidator<Before, Date> {

    private Before annotation;

    @Override
    public void initialize(Before constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(annotation.format());
        try {
            Date beforeDate = sdf.parse(annotation.value());
            boolean isBefore = value.before(beforeDate);
            return isBefore;
        } catch (ParseException e) {
            return false;
        }
    }
}
