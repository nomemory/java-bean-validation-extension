package net.andreinc.jvbe.str.validators;

import net.andreinc.jvbe.str.AllBlank;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class AllBlankValidator extends GenericStringValidator<AllBlank> {
    @Override
    public Function<String, Boolean> condition() {
        return StringUtils::isAllBlank;
    }
}
