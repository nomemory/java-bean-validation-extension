package net.andreinc.jbvext.annotations.digits;

import net.andreinc.jbvext.annotations.digits.validator.MaxDigitsDoubleValidator;
import net.andreinc.jbvext.annotations.digits.validator.MinDigitsDoubleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = MaxDigitsDoubleValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(MaxDigits.List.class)
public @interface MaxDigits {

    String value();

    String message() default "{javax.validation.constraints.MaxDigits.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@code @MaxDigits} constraints on the same element.
     *
     * @see MaxDigits
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        MaxDigits[] value();
    }
}
