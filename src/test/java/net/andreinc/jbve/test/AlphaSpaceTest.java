package net.andreinc.jbve.test;

import lombok.Data;
import net.andreinc.jbve.annotations.str.AlphaSpace;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AlphaSpaceTest {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        AlphaSpaceBeanFields alphaSpaceBeanFields = new AlphaSpaceBeanFields();

        Set<ConstraintViolation<AlphaSpaceBeanFields>> violations =
                validator.validate(alphaSpaceBeanFields);

        Assert.assertEquals(2, violations.size());
    }

    @Test
    public void testMethods() {
        AlphaSpaceBeanMethods alphaSpaceBeanMethods = new AlphaSpaceBeanMethods();

        Set<ConstraintViolation<AlphaSpaceBeanMethods>> violations =
                validator.validate(alphaSpaceBeanMethods);

        Assert.assertEquals(2, violations.size());
    }

    @Test
    public void testType() {
        AlphaSpaceList alphaSpaceList = new AlphaSpaceList();

        Set<ConstraintViolation<AlphaSpaceList>> violations =
                validator.validate(alphaSpaceList);

        Assert.assertEquals(2, violations.size());
    }
}

@Data
class AlphaSpaceBeanFields {

    @AlphaSpace
    private String alphaSpace = "abc ABC";

    @AlphaSpace
    private String alphaSpaceEmpty = "";

    @AlphaSpace
    private String alphaSpaceNull = null;

    @AlphaSpace
    private String alphaSpaceWrong = "abc 123";
}

@Data
class AlphaSpaceBeanMethods {

    @AlphaSpace
    private String getAlphaSpace() {
        return "abc ABC";
    }

    @AlphaSpace
    private String getAlphaSpaceEmpty() {
        return "";
    }

    @AlphaSpace
    private String getAlphaSpaceNull() {
        return null;
    }

    @AlphaSpace
    private String getAlphaSpaceWrong() {
        return "abc 123";
    }
}

@Data
class AlphaSpaceList {
    private List<@AlphaSpace String> strings = Arrays.asList("abc ABC", "", null, "abc 123");
}
