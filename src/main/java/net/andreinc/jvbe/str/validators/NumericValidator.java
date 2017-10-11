package net.andreinc.jvbe.str.validators;

import net.andreinc.jvbe.str.Numeric;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class NumericValidator extends GenericStringValidator<Numeric> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isNumeric;
    }
}
