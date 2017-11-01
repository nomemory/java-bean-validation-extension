package net.andreinc.jbvext.annotations.str.validators;

import net.andreinc.jbvext.annotations.str.Blank;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class BlankValidator extends GenericStringValidator<Blank> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isBlank;
    }
}
