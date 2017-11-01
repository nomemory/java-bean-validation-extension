package net.andreinc.jbvext.annotations.str.validators;

import net.andreinc.jbvext.annotations.str.LowerCase;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class LowerCaseValidator extends GenericStringValidator<LowerCase> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAllLowerCase;
    }
}
