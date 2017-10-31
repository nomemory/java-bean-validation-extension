package net.andreinc.jbve.annotations.str.validators;

import net.andreinc.jbve.annotations.str.UpperCase;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class UpperCaseValidator extends GenericStringValidator<UpperCase> {

    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAllUpperCase;
    }

}
