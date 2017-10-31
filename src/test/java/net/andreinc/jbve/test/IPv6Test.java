package net.andreinc.jbve.test;

import lombok.Data;
import net.andreinc.jbve.annotations.str.IPv6;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class IPv6Test {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        IPv6BeanFields IPv6BeanFields = new IPv6BeanFields();

        Set<ConstraintViolation<IPv6BeanFields>> violations =
                validator.validate(IPv6BeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        IPv6BeanMethods IPv6BeanMethods = new IPv6BeanMethods();

        Set<ConstraintViolation<IPv6BeanMethods>> violations =
                validator.validate(IPv6BeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        IPv6BeanType IPv6BeanType = new IPv6BeanType();

        Set<ConstraintViolation<IPv6BeanType>> violations =
                validator.validate(IPv6BeanType);

        Assert.assertEquals(0, violations.size());
    }
}

@Data
class IPv6BeanFields {

    @IPv6
    private String correct = "::1";

    @IPv6
    private String incorrect = "abc";
}

@Data
class IPv6BeanMethods {

    @IPv6
    private String getCorrect() {
        return "::1";
    }

    @IPv6
    private String getIncorrect() {
        return "abc";
    }
}

@Data
class IPv6BeanType {
    private List<@IPv6 String> ips = Arrays.asList("::1");
}