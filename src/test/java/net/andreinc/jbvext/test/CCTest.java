package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.str.CC;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static net.andreinc.jbvext.annotations.str.CreditCardType.AMEX;
import static net.andreinc.jbvext.annotations.str.CreditCardType.VISA;

public class CCTest {

    public static final String AMEX_CC = "340000000000009";
    public static final String VISA_CC = "4111111111111111";

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        CCBeanFields blankBeanFields = new CCBeanFields();

        Set<ConstraintViolation<CCBeanFields>> violations =
                validator.validate(blankBeanFields);

        Assert.assertEquals(0, violations.size());
    }
}


@Data
class CCBeanFields {
    @CC(AMEX)
    private String amex = CCTest.AMEX_CC;

    @CC({AMEX, VISA})
    private String amexOrVisa = CCTest.AMEX_CC;

    @CC({VISA})
    private String visa = CCTest.VISA_CC;
}