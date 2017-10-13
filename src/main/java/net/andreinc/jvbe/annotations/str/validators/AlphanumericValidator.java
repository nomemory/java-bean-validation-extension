package net.andreinc.jvbe.annotations.str.validators;

import net.andreinc.jvbe.annotations.str.Alphanumeric;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class AlphanumericValidator extends GenericStringValidator<Alphanumeric> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAlphanumeric;
    }
}
