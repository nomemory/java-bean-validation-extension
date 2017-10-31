package net.andreinc.jbve.test;

import lombok.Data;
import net.andreinc.jbve.annotations.date.IsDate;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class IsDateTest {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void testField() {
        IsDateBean isDateBean = new IsDateBean();

        Set<ConstraintViolation<IsDateBean>> violations =
                validator.validate(isDateBean);

        Assert.assertEquals(0, violations.size());
    }
}

@Data
class IsDateBean {
    @IsDate("yyyy-MM-dd")
    private String isDate = "2018-12-01"; // Passes
}