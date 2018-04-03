package net.andreinc.jbvext.annotations.digits.validator;


import net.andreinc.jbvext.annotations.digits.MinDigits;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinDigitsDoubleValidator implements ConstraintValidator<MinDigits, Double> {

    private MinDigits annotation;

    @Override
    public void initialize(MinDigits constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }

        Double minDigitsValue = Double.valueOf(this.annotation.value());

        int result = Double.compare(value, minDigitsValue);

        if (0 == result){
            // Value is equal to min
            return true;
        } else if (result < 0){
            // Value is less than min
            return false;
        } else if (result > 0){
            // Value is greater than min
            return true;
        } else {
            throw new IllegalArgumentException("How this could be possible");
        }

    }
}
