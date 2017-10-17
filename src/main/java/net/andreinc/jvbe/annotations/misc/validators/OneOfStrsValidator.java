package net.andreinc.jvbe.annotations.misc.validators;

import net.andreinc.jvbe.annotations.misc.OneOfStrs;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;

public class OneOfStrsValidator extends OneOfValidator<OneOfStrs, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return super.isValid(value, annotation.value(), StringUtils::equals, context);
    }
}
