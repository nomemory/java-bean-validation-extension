package net.andreinc.jbve.annotations.str;

import net.andreinc.jbve.annotations.str.validators.BlankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks if a String is whitespace, empty ("") or null.
 */
@Documented
@Constraint(validatedBy = BlankValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface Blank {
    String message() default "{str.blank}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}