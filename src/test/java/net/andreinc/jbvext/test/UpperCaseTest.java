package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.str.UpperCase;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class UpperCaseTest {
    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        UpperCaseBeanFields upperCaseBeanFields = new UpperCaseBeanFields();

        Set<ConstraintViolation<UpperCaseBeanFields>> violations =
                validator.validate(upperCaseBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        UpperCaseBeanMethods upperCaseBeanMethods = new UpperCaseBeanMethods();

        Set<ConstraintViolation<UpperCaseBeanMethods>> violations =
                validator.validate(upperCaseBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        UpperCaseBeanType upperCaseBeanType = new UpperCaseBeanType();

        Set<ConstraintViolation<UpperCaseBeanType>> violations =
                validator.validate(upperCaseBeanType);

        Assert.assertEquals(0, violations.size());
    }
}

@Data
class UpperCaseBeanFields {

    @UpperCase
    private String correct = "ABC";

    @UpperCase
    private String incorrect = "aBC";
}

@Data
class UpperCaseBeanMethods {

    @UpperCase
    private String getCorrect() {
        return "ABC";
    }

    @UpperCase
    private String getIncorrect() {
        return "aBC";
    }
}

@Data
class UpperCaseBeanType {
    private List<@UpperCase String> sts = Arrays.asList("ABC", "AXXX");
}



