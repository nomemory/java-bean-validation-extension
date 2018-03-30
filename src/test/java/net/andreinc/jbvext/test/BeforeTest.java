package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.date.Before;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BeforeTest {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void testFieldOk() {
        BeforeBean beforeBean = new BeforeBean();

        Set<ConstraintViolation<BeforeBean>> violations =
                validator.validate(beforeBean);

        Assert.assertEquals(0, violations.size());
    }


    @Test
    public void testFieldKo() {
        NotBeforeBean notBeforeBean = new NotBeforeBean();

        Set<ConstraintViolation<NotBeforeBean>> violations =
                validator.validate(notBeforeBean);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        BeforeBeanMethods beforeBeanMethods = new BeforeBeanMethods();

        Set<ConstraintViolation<BeforeBeanMethods>> violations =
                validator.validate(beforeBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        BeforeBeanType beforeBeanType = new BeforeBeanType();

        Set<ConstraintViolation<BeforeBeanType>> violations =
                validator.validate(beforeBeanType);

        Assert.assertEquals(1, violations.size());
    }
}

@Data
class BeforeBean {
    @Before(value = "2018-12-01", format = "yyyy-MM-dd")
    private Date isBefore = new Date(1522399999911L); // Passes // Date = 2018-03-30
}


@Data
class NotBeforeBean {
    @Before(value = "2017-12-01", format = "yyyy-MM-dd")
    private Date isNotBefore = new Date(1522399999911L); // Doesn't Passes Date = 2018-03-30
}


@Data
class BeforeBeanMethods {

    @Before(value = "2018-12-01", format = "yyyy-MM-dd")
    private Date getBefore(){
        return new Date(1522399999911L); // Passes
    }

    @Before(value = "2017-12-01", format = "yyyy-MM-dd")
    private Date getNotBefore(){
      return new Date(1522399999911L); // Doesn't Passes
    }
}

@Data
class BeforeBeanType {

    private List<@Before(value = "2018-01-01", format = "yyyy-MM-dd") Date> list = Arrays.asList(new Date(1512082800000L), new Date(1522399999911L));

}