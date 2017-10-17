package net.andreinc.jvbe.annotations.misc.validators;


import net.andreinc.jvbe.annotations.misc.OneOfInts;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class OneOfIntsValidator extends OneOfValidator<OneOfInts, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return super.isValid(value, ArrayUtils.toObject(annotation.value()), Objects::equals, context);
    }
}
