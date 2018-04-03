package net.andreinc.jbvext.annotations.digits.validator;


import net.andreinc.jbvext.annotations.digits.MaxDigits;
import net.andreinc.jbvext.annotations.digits.MinDigits;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxDigitsDoubleValidator implements ConstraintValidator<MaxDigits, Double> {

    private MaxDigits annotation;

    @Override
    public void initialize(MaxDigits constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }

        Double maxDigitsValue = Double.valueOf(this.annotation.value());

        int result = Double.compare(value, maxDigitsValue);

        if (0 == result){
            // Value is equal to min
            return true;
        } else if (result < 0){
            // Value is less than min
            return true;
        } else if (result > 0){
            // Value is greater than min
            return false;
        } else {
            throw new IllegalArgumentException("How this could be possible");
        }

    }
}
