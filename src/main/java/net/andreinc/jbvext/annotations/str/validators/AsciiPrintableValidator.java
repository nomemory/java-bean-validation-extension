package net.andreinc.jbvext.annotations.str.validators;

import net.andreinc.jbvext.annotations.str.AsciiPrintable;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class AsciiPrintableValidator extends GenericStringValidator<AsciiPrintable> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAsciiPrintable;
    }
}
