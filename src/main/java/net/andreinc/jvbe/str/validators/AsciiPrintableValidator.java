package net.andreinc.jvbe.str.validators;

import net.andreinc.jvbe.str.AsciiPrintable;

import java.util.function.Function;

public class AsciiPrintableValidator extends GenericStringValidator<AsciiPrintable> {
    @Override
    public Function<String, Boolean> condition() {
        return null;
    }
}
