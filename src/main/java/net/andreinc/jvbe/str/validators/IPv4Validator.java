package net.andreinc.jvbe.str.validators;

import net.andreinc.jvbe.str.IPv4;
import org.apache.commons.validator.routines.InetAddressValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IPv4Validator implements ConstraintValidator<IPv4, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return InetAddressValidator
                .getInstance()
                .isValidInet4Address(value);
    }
}
