package net.andreinc.jbvext.annotations.str.validators;

import net.andreinc.jbvext.annotations.str.Numeric;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class NumericValidator extends GenericStringValidator<Numeric> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isNumeric;
    }
}
