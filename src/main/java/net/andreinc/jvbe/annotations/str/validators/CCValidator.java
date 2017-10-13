package net.andreinc.jvbe.annotations.str.validators;

import net.andreinc.jvbe.annotations.str.CC;
import net.andreinc.jvbe.annotations.str.CreditCardType;
import org.apache.commons.validator.routines.CreditCardValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CCValidator implements ConstraintValidator<CC, String> {

    private CC annotation;

    @Override
    public void initialize(CC constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return false;
        }

        CreditCardType[] types = annotation.value();

        for(CreditCardType creditCardType : types) {
            CreditCardValidator ccv =
                    new CreditCardValidator(creditCardType.getInternalValue());
            if (ccv.isValid(value)) {
                return true;
            }
        }

        return false;
    }
}
