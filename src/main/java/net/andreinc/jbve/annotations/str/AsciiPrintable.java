package net.andreinc.jbve.annotations.str;

import net.andreinc.jbve.annotations.str.validators.AsciiPrintableValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks if the string contains only ASCII printable characters.
 */
@Documented
@Constraint(validatedBy = AsciiPrintableValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface AsciiPrintable {
    String message() default "{str.asciiprintable}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}