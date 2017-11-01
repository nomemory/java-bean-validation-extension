package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.str.Numeric;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class NumericTest {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        NumericBeanFields numericBeanFields = new NumericBeanFields();

        Set<ConstraintViolation<NumericBeanFields>> violations =
                validator.validate(numericBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        NumericBeanMethods numericBeanMethods = new NumericBeanMethods();

        Set<ConstraintViolation<NumericBeanMethods>> violations =
                validator.validate(numericBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        NumericBeanType numericBeanType = new NumericBeanType();

        Set<ConstraintViolation<NumericBeanType>> violations =
                validator.validate(numericBeanType);

        Assert.assertEquals(0, violations.size());
    }
}


@Data
class NumericBeanFields {

    @Numeric
    private String correct = "123";

    @Numeric
    private String incorrect = "a123";
}

@Data
class NumericBeanMethods {
    @Numeric
    private String getCorrect() {
        return "123";
    }

    @Numeric
    private String getIncorrect() {
        return "a123";
    }
}

@Data
class NumericBeanType {
    private List<@Numeric String> nums = Arrays.asList("123", "0");
}