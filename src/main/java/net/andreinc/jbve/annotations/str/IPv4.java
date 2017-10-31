package net.andreinc.jbve.annotations.str;

import net.andreinc.jbve.annotations.str.validators.IPv4Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks if the string is a valid IPv4 address.
 */
@Documented
@Constraint(validatedBy = IPv4Validator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface IPv4 {
    String message() default "{string.ipv4}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
