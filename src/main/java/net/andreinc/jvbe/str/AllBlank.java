package net.andreinc.jvbe.str;

import net.andreinc.jvbe.str.validators.AllBlankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks if all of the CharSequences are empty (""), null or whitespace only.
 */
@Documented
@Constraint(validatedBy = AllBlankValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface AllBlank {
    String message() default "{str.allblank}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

