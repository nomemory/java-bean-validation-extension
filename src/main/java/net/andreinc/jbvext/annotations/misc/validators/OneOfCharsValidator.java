package net.andreinc.jbvext.annotations.misc.validators;

import net.andreinc.jbvext.annotations.misc.OneOfChars;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class OneOfCharsValidator extends OneOfValidator<OneOfChars, Character> {
    @Override
    public boolean isValid(Character value, ConstraintValidatorContext context) {
        return super.isValid(value, ArrayUtils.toObject(annotation.value()), Objects::equals, context);
    }
}
