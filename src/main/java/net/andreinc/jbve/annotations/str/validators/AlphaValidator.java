package net.andreinc.jbve.annotations.str.validators;

import net.andreinc.jbve.annotations.str.Alpha;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class AlphaValidator extends GenericStringValidator<Alpha> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAlpha;
    }
}
