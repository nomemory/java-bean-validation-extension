package net.andreinc.jbvext.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.andreinc.jbvext.annotations.misc.OneOfStrings;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class OneOfStringsTest {
    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        OneOfStringsBeanFields oneOfStringsBeanFields = new OneOfStringsBeanFields("A");

        Set<ConstraintViolation<OneOfStringsBeanFields>> violations =
                validator.validate(oneOfStringsBeanFields);

        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void testFieldsIncorrect() {
        OneOfStringsBeanFields oneOfStringsBeanFields = new OneOfStringsBeanFields("Z");

        Set<ConstraintViolation<OneOfStringsBeanFields>> violations =
                validator.validate(oneOfStringsBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testFieldsWithNull() {
        OneOfStringsBeanFields oneOfStringsBeanFields = new OneOfStringsBeanFields(null);

        Set<ConstraintViolation<OneOfStringsBeanFields>> violations =
                validator.validate(oneOfStringsBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        OneOfStringsBeanMethods oneOfStringsBeanMethods = new OneOfStringsBeanMethods("A");

        Set<ConstraintViolation<OneOfStringsBeanMethods>> violations =
                validator.validate(oneOfStringsBeanMethods);

        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void testType() {
        OneOfStringsBeanType oneOfStringsBeanType = new OneOfStringsBeanType(Arrays.asList("A"));

        Set<ConstraintViolation<OneOfStringsBeanType>> violations =
                validator.validate(oneOfStringsBeanType);

        Assert.assertEquals(0, violations.size());
    }
}

@Data
@AllArgsConstructor
@Valid class OneOfStringsBeanFields {
    @OneOfStrings({"A", "B"})
    private String aString;
}

@Data
@AllArgsConstructor
class OneOfStringsBeanMethods {

    private String aString;

    @OneOfStrings({"A", "B"})
    private String getAString() {
        return aString;
    }
}

@Data
@AllArgsConstructor
class OneOfStringsBeanType {
    private List<@OneOfStrings({"A", "B"}) String> strs;
}