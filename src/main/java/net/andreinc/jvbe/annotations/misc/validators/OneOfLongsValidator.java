package net.andreinc.jvbe.annotations.misc.validators;

import net.andreinc.jvbe.annotations.misc.OneOfLongs;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class OneOfLongsValidator extends OneOfValidator<OneOfLongs, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return super.isValid(value, ArrayUtils.toObject(annotation.value()), Objects::equals, context);
    }
}
