package net.andreinc.jbve.annotations.misc.validators;

import net.andreinc.jbve.annotations.misc.OneOfDoubles;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class OneOfDoublesValidator extends OneOfValidator<OneOfDoubles, Double> {

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return super.isValid(value, ArrayUtils.toObject(annotation.value()), Objects::equals, context);
    }

}
