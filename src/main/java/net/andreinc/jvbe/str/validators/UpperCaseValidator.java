package net.andreinc.jvbe.str.validators;

import net.andreinc.jvbe.str.UpperCase;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class UpperCaseValidator extends GenericStringValidator<UpperCase> {

    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAllUpperCase;
    }

}
