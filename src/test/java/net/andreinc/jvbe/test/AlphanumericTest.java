package net.andreinc.jvbe.test;

import lombok.Data;
import net.andreinc.jvbe.annotations.str.Alphanumeric;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class AlphanumericTest {
    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        AlphanumericBeanField alphanumericBeanField = new AlphanumericBeanField();

        Set<ConstraintViolation<AlphanumericBeanField>> violations =
                validator.validate(alphanumericBeanField);

        Assert.assertEquals(3, violations.size());
    }

    @Test
    public void testTypeParam() {
        AlphanumericList alphanumericList = new AlphanumericList();

        Set<ConstraintViolation<AlphanumericList>> violations =
                validator.validate(alphanumericList);

        Assert.assertEquals(3, violations.size());
    }

    @Test
    public void testMethods() {
        AlphanumericBeanMethods alphanumericBeanMethods = new AlphanumericBeanMethods();

        Set<ConstraintViolation<AlphanumericBeanMethods>> violations =
                validator.validate(alphanumericBeanMethods);

        Assert.assertEquals(3, violations.size());
    }
}

@Data
class AlphanumericBeanField {

    @Alphanumeric
    private String alphanumeric = "123AAAaaa111";

    @Alphanumeric
    private String alphanumericNull = null;

    @Alphanumeric
    private String alphanumericEmpty = "";

    @Alphanumeric
    private String alphanumericWrong = "   aaa11AA2";
}

@Data
class AlphanumericBeanMethods {

    @Alphanumeric
    private String getAlphanumeric() {
        return "123AAAaaa111";
    }

    @Alphanumeric
    private String getAlphanumericNull() {
        return null;
    }

    @Alphanumeric
    private String getAlphanumericEmpty() {
        return "";
    }

    @Alphanumeric
    private String getAlphanumericWrong() {
        return "   aaa11AA2";
    }
}

@Data
class AlphanumericList {
    private List<@Alphanumeric String> strings = asList("123AAAaaa111", null, "", "   aaa11AA2");
}