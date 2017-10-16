package net.andreinc.jvbe.test;

import lombok.Data;
import net.andreinc.jvbe.annotations.str.AsciiPrintable;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static net.andreinc.jvbe.test.AsciiPrintableTest.EOF;

public class AsciiPrintableTest {
    public static final String EOF = "\u0003";

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        AsciiPrintableBeanFields asciiPrintableBeanFields = new AsciiPrintableBeanFields();

        Set<ConstraintViolation<AsciiPrintableBeanFields>> violations =
                validator.validate(asciiPrintableBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        AsciiPrintableBeanMethods asciiPrintableBeanMethods = new AsciiPrintableBeanMethods();

        Set<ConstraintViolation<AsciiPrintableBeanMethods>> violations =
                validator.validate(asciiPrintableBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    public void testType() {
        AsciiPrintableType asciiPrintableType = new AsciiPrintableType();

        Set<ConstraintViolation<AsciiPrintableType>> violations =
                validator.validate(asciiPrintableType);

        Assert.assertEquals(1, violations.size());
    }
}

@Data
class AsciiPrintableBeanFields {

    @AsciiPrintable
    private String printable = "abc";

    @AsciiPrintable
    private String nonPrintable = "abc" + EOF;
}

@Data
class AsciiPrintableBeanMethods {

    @AsciiPrintable
    private String getPrintable() {
        return "abc";
    }

    ;

    @AsciiPrintable
    private String getNonPrintable() {
        return "abc" + EOF;
    }
}

@Data
class AsciiPrintableType {
    private List<@AsciiPrintable String> list = Arrays.asList("abc", EOF);
}

