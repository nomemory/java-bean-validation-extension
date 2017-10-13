package net.andreinc.jvbe.annotations.str.validators;

import net.andreinc.jvbe.annotations.str.Numeric;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class NumericValidator extends GenericStringValidator<Numeric> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isNumeric;
    }
}
