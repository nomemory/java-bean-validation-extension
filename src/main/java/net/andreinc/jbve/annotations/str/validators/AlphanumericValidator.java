package net.andreinc.jbve.annotations.str.validators;

import net.andreinc.jbve.annotations.str.Alphanumeric;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class AlphanumericValidator extends GenericStringValidator<Alphanumeric> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAlphanumeric;
    }
}
