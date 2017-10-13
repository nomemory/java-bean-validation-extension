package net.andreinc.jvbe.annotations.str.validators;

import net.andreinc.jvbe.annotations.str.Blank;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class BlankValidator extends GenericStringValidator<Blank> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isBlank;
    }
}
