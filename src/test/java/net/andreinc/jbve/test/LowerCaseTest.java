package net.andreinc.jbve.test;

import lombok.Data;
import net.andreinc.jbve.annotations.str.LowerCase;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LowerCaseTest {
    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        LowerCaseBeanFields lowerCaseBeanFields = new LowerCaseBeanFields();

        Set<ConstraintViolation<LowerCaseBeanFields>> violations =
                validator.validate(lowerCaseBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        LowerCaseBeanMethods lowerCaseBeanMethods = new LowerCaseBeanMethods();

        Set<ConstraintViolation<LowerCaseBeanMethods>> violations =
                validator.validate(lowerCaseBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        LowerCaseBeanType lowerCaseBeanType = new LowerCaseBeanType();

        Set<ConstraintViolation<LowerCaseBeanType>> violations =
                validator.validate(lowerCaseBeanType);

        Assert.assertEquals(0, violations.size());
    }
}

@Data
class LowerCaseBeanFields {

    @LowerCase
    private String correct = "abc";

    @LowerCase
    private String incorrect = "Abc";
}

@Data
class LowerCaseBeanMethods {

    @LowerCase
    private String getCorrect() {
        return "abc";
    }

    @LowerCase
    private String getIncorrect() {
        return "Abc";
    }
}

@Data
class LowerCaseBeanType {
    private List<@LowerCase String> sts = Arrays.asList("abc", "axxx");
}

