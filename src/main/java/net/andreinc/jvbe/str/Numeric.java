package net.andreinc.jvbe.str;

import net.andreinc.jvbe.str.validators.NumericValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks if the string is numeric
 */
@Documented
@Constraint(validatedBy = NumericValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface Numeric {
    String message() default "{string.numeric}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
