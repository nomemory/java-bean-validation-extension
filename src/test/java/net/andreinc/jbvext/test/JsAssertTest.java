package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.exp.JsAssert;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Data
@JsAssert("_.name === 'abc'")
class JsAssertObject {
    private String name = "abc";
}

public class JsAssertTest {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testJsAssertObject() {
        JsAssertObject jsAssertObject = new JsAssertObject();
        Set<ConstraintViolation<JsAssertObject>> violations =
                validator.validate(jsAssertObject);

        System.out.println(violations);

        Assert.assertEquals(0, violations.size());
    }
}
