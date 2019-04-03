package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.digits.MinDigits;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MinDigitsDoubleValidatorTest  {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void testFields() {
        MinDigitsDoubleBean minDigitsDoubleBean = new MinDigitsDoubleBean();

        Set<ConstraintViolation<MinDigitsDoubleBean>> violations =
                validator.validate(minDigitsDoubleBean);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        MinDigitsDoubleBeanMethods minDigitsDoubleBean = new MinDigitsDoubleBeanMethods();

        Set<ConstraintViolation<MinDigitsDoubleBeanMethods>> violations =
                validator.validate(minDigitsDoubleBean);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        MinDigitsDoubleBeanType minDigitsDoubleBean = new MinDigitsDoubleBeanType();

        Set<ConstraintViolation<MinDigitsDoubleBeanType>> violations =
                validator.validate(minDigitsDoubleBean);

        Assert.assertEquals(1, violations.size());
    }
}

@Data
class MinDigitsDoubleBean {
    @MinDigits(value = "10.5")
    private Double isOk = new Double(11.0); // Passes

    @MinDigits(value = "10.5")
    private Double isKo = new Double(10.0); // Do not Pass
}


@Data
class MinDigitsDoubleBeanMethods {

    @MinDigits(value = "10.5")
    private Double getOk(){
        return new Double(11.0); // Passes
    }

    @MinDigits(value = "10.5")
    private Double getKo(){
        return new Double(10.0); // Do not Pass
    }
}

@Data
class MinDigitsDoubleBeanType {

    private List<@MinDigits(value = "10.5") Double> list = Arrays.asList(
            new Double(11.0),
            new Double(10.5),
            new Double(10.0)
    );

}
