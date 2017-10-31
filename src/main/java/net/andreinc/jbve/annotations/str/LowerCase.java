package net.andreinc.jbve.annotations.str;

import net.andreinc.jbve.annotations.str.validators.LowerCaseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks if the String contains only lowercase characters.
 */
@Documented
@Constraint(validatedBy = LowerCaseValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface LowerCase {
    String message() default "{string.lowercase}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
