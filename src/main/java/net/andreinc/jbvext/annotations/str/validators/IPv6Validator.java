package net.andreinc.jbvext.annotations.str.validators;

import net.andreinc.jbvext.annotations.str.IPv6;
import org.apache.commons.validator.routines.InetAddressValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IPv6Validator implements ConstraintValidator<IPv6, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return InetAddressValidator
                .getInstance()
                .isValidInet6Address(value);
    }
}
