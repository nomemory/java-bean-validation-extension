package net.andreinc.jvbe.test;

import lombok.Data;
import net.andreinc.jvbe.annotations.str.CC;

import javax.validation.Validation;
import javax.validation.Validator;

import static net.andreinc.jvbe.annotations.str.CreditCardType.AMEX;
import static net.andreinc.jvbe.annotations.str.CreditCardType.VISA;

public class CCTest {

    public static final String AMEX_CC = "340000000000009";
    public static final String VISA_CC = "4111111111111111";

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();
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