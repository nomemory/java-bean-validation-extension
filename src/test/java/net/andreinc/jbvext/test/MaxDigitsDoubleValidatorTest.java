package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.digits.MaxDigits;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MaxDigitsDoubleValidatorTest  {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void testFields() {
        MaxDigitsDoubleBean MaxDigitsDoubleBean = new MaxDigitsDoubleBean();

        Set<ConstraintViolation<MaxDigitsDoubleBean>> violations =
                validator.validate(MaxDigitsDoubleBean);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        MaxDigitsDoubleBeanMethods MaxDigitsDoubleBean = new MaxDigitsDoubleBeanMethods();

        Set<ConstraintViolation<MaxDigitsDoubleBeanMethods>> violations =
                validator.validate(MaxDigitsDoubleBean);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        MaxDigitsDoubleBeanType MaxDigitsDoubleBean = new MaxDigitsDoubleBeanType();

        Set<ConstraintViolation<MaxDigitsDoubleBeanType>> violations =
                validator.validate(MaxDigitsDoubleBean);

        Assert.assertEquals(1, violations.size());
    }
}

@Data
class MaxDigitsDoubleBean {
    @MaxDigits(value = "10.5")
    private Double isKo = new Double(11.0); // Do not Pass

    @MaxDigits(value = "10.5")
    private Double isOk = new Double(10.0); // Passes
}


@Data
class MaxDigitsDoubleBeanMethods {

    @MaxDigits(value = "10.5")
    private Double getOk(){
        return new Double(10.0); // Passes
    }

    @MaxDigits(value = "10.5")
    private Double getKo(){
        return new Double(11.0); // Do not Pass
    }


}

@Data
class MaxDigitsDoubleBeanType {

    private List<@MaxDigits(value = "10.5") Double> list = Arrays.asList(
            new Double(11.0),
            new Double(10.5),
            new Double(10.0)
    );

}
