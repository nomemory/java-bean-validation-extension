package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.digits.MaxDigits;
import net.andreinc.jbvext.annotations.digits.MinDigits;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class MinDigitsMaxDigitsTest {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void testFields() {
        MinDigitsMaxDigitsDoubleBean minDigitsMaxDigitsDoubleBean = new MinDigitsMaxDigitsDoubleBean();


        Set<ConstraintViolation<MinDigitsMaxDigitsDoubleBean>> violations =
                validator.validate(minDigitsMaxDigitsDoubleBean);

        Assert.assertEquals(2, violations.size());
    }

    @Data
    class MinDigitsMaxDigitsDoubleBean {
        @MinDigits(value = "10.5")
        @MaxDigits(value = "11.5")
        private Double isOk = new Double(11.0); // Passes

        @MinDigits(value = "9.5")
        @MaxDigits(value = "9.6")
        private Double isTooHigh = new Double(10.0); // Do not Pass


        @MinDigits(value = "9.5")
        @MaxDigits(value = "9.6")
        private Double isTooLow = new Double(9.2); // Do not Pass
    }
}
