package net.andreinc.jbvext.annotations.str;

import net.andreinc.jbvext.annotations.str.validators.CCValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks if the string can be a valid credit card number.
 */
@Documented
@Constraint(validatedBy = CCValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface CC {
    String message() default "{str.creditcard}";
    CreditCardType[] value() default {CreditCardType.ALL};
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
