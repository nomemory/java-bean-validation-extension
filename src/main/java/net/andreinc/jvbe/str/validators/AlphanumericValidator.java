package net.andreinc.jvbe.str.validators;

import net.andreinc.jvbe.str.Alphanumeric;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class AlphanumericValidator extends GenericStringValidator<Alphanumeric> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAlphanumeric;
    }
}
