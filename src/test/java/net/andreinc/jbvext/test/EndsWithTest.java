package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.str.EndsWith;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class EndsWithTest {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        EndsWithBeanFields endsWithBeanFields = new EndsWithBeanFields();

        Set<ConstraintViolation<EndsWithBeanFields>> violations =
                validator.validate(endsWithBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        EndsWithBeanMethods endsWithBeanMethods = new EndsWithBeanMethods();

        Set<ConstraintViolation<EndsWithBeanMethods>> violations =
                validator.validate(endsWithBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        EndsWithBeanType endsWithBeanType = new EndsWithBeanType();

        Set<ConstraintViolation<EndsWithBeanType>> violations =
                validator.validate(endsWithBeanType);

        Assert.assertEquals(0, violations.size());
    }
}


@Data
class EndsWithBeanFields {

    @EndsWith("abc")
    private String correct = "abc";

    @EndsWith("abc")
    private String incorrect = "abcd";
}

@Data
class EndsWithBeanMethods {

    @EndsWith("abc")
    private String getCorrect() {
        return "abc";
    }

    @EndsWith("abc")
    private String getIncorrect() {
        return "abcd";
    }
}

@Data
class EndsWithBeanType {

    private List<@EndsWith("abc") String> getStrs = Arrays.asList("abc", "1abc", "0abc");
}