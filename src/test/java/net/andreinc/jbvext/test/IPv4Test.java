package net.andreinc.jbvext.test;


import lombok.Data;
import net.andreinc.jbvext.annotations.str.IPv4;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class IPv4Test {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        IPv4BeanFields iPv4BeanFields = new IPv4BeanFields();

        Set<ConstraintViolation<IPv4BeanFields>> violations =
                validator.validate(iPv4BeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        IPv4BeanMethods iPv4BeanMethods = new IPv4BeanMethods();

        Set<ConstraintViolation<IPv4BeanMethods>> violations =
                validator.validate(iPv4BeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        IPv4BeanType iPv4BeanType = new IPv4BeanType();

        Set<ConstraintViolation<IPv4BeanType>> violations =
                validator.validate(iPv4BeanType);

        Assert.assertEquals(0, violations.size());
    }
}

@Data
class IPv4BeanFields {

    @IPv4
    private String correct = "127.0.0.1";

    @IPv4
    private String incorrect = "abc";
}

@Data
class IPv4BeanMethods {

    @IPv4
    private String getCorrect() {
        return "127.0.0.1";
    }

    @IPv4
    private String getIncorrect() {
        return "abc";
    }
}

@Data
class IPv4BeanType {
    private List<@IPv4 String> ips = Arrays.asList("127.0.0.1");
}