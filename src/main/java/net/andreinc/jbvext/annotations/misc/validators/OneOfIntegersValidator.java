package net.andreinc.jbvext.annotations.misc.validators;


import net.andreinc.jbvext.annotations.misc.OneOfIntegers;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class OneOfIntegersValidator extends OneOfValidator<OneOfIntegers, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return super.isValid(value, ArrayUtils.toObject(annotation.value()), Objects::equals, context);
    }
}
