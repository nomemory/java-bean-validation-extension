package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.date.After;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class AfterTest {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void testFieldOk() {
        AfterBean AfterBean = new AfterBean();

        Set<ConstraintViolation<AfterBean>> violations =
                validator.validate(AfterBean);

        Assert.assertEquals(0, violations.size());
    }


    @Test
    public void testFieldKo() {
        NotAfterBean notAfterBean = new NotAfterBean();

        Set<ConstraintViolation<NotAfterBean>> violations =
                validator.validate(notAfterBean);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        AfterBeanMethods AfterBeanMethods = new AfterBeanMethods();

        Set<ConstraintViolation<AfterBeanMethods>> violations =
                validator.validate(AfterBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        AfterBeanType AfterBeanType = new AfterBeanType();

        Set<ConstraintViolation<AfterBeanType>> violations =
                validator.validate(AfterBeanType);

        Assert.assertEquals(1, violations.size());
    }
}

@Data
class AfterBean {
    @After(value = "2018-01-01", format = "yyyy-MM-dd")
    private Date isAfter = new Date(1522399999911L); // Passes // Date = 2018-03-30
}


@Data
class NotAfterBean {
    @After(value = "2018-12-01", format = "yyyy-MM-dd")
    private Date isNotAfter = new Date(1522399999911L); // Doesn't Passes Date = 2018-03-30
}


@Data
class AfterBeanMethods {

    @After(value = "2018-12-01", format = "yyyy-MM-dd")
    private Date getAfter(){
        return new Date(1522399999911L); // Passes
    }

    @After(value = "2017-12-01", format = "yyyy-MM-dd")
    private Date getNotAfter(){
      return new Date(1522399999911L); // Doesn't Passes
    }
}

@Data
class AfterBeanType {

    private List<@After(value = "2018-01-01", format = "yyyy-MM-dd") Date> list = Arrays.asList(new Date(1512082800000L), new Date(1522399999911L));

}