package net.andreinc.jbve.test;

import lombok.Data;
import net.andreinc.jbve.annotations.str.StartsWith;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StartsWithTest {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        StartsWithBeanFields startsWithBeanFields = new StartsWithBeanFields();

        Set<ConstraintViolation<StartsWithBeanFields>> violations =
                validator.validate(startsWithBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        StartsWithBeanMethods startsWithBeanMethods = new StartsWithBeanMethods();

        Set<ConstraintViolation<StartsWithBeanMethods>> violations =
                validator.validate(startsWithBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        StartsWithBeanType startsWithBeanType = new StartsWithBeanType();

        Set<ConstraintViolation<StartsWithBeanType>> violations =
                validator.validate(startsWithBeanType);

        Assert.assertEquals(0, violations.size());
    }

}

@Data
class StartsWithBeanFields {

    @StartsWith("A")
    private String correct = "ABC";

    @StartsWith("B")
    private String incorrect = "ABC";
}

@Data
class StartsWithBeanMethods {

    @StartsWith("A")
    private String getCorrect() {
        return "ABC";
    }

    @StartsWith("B")
    private String getIncorrect() {
        return "ABC";
    }
}

class StartsWithBeanType {
    private List<@StartsWith("A") String> strs = Arrays.asList("ABC", "AND");
}