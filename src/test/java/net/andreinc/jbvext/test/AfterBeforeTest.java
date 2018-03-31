package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.date.After;
import net.andreinc.jbvext.annotations.date.Before;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.Set;

public class AfterBeforeTest {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void testFieldOk() {
        AfterBeforeBean afterBeforeBean = new AfterBeforeBean();

        Set<ConstraintViolation<AfterBeforeBean>> violations =
                validator.validate(afterBeforeBean);

        Assert.assertEquals(0, violations.size());
    }
}

@Data
class AfterBeforeBean {
    @After(value = "2018-01-01", format = "yyyy-MM-dd")
    @Before(value = "2100-01-01", format = "yyyy-MM-dd")
    private Date isAfter = new Date(1522399999911L); // Passes // Date = 2018-03-30
}
